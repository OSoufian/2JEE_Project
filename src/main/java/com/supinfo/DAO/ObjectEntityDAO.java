package com.supinfo.DAO;

import com.supinfo.Dto.ObjectEntityDto;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.servlet.http.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Stateless
public class ObjectEntityDAO {
    private DAOConnect daoConnect;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    public EntityManager em = emf.createEntityManager();

    public List<ObjectEntityDto> getByNameDesPri(String search)
    {
        return em.createNamedQuery("Obj.findByNameDesPri", ObjectEntityDto.class)
                .setParameter("name", "%"+search+"%")
                .setParameter("description", "%"+search+"%")
                .setParameter("price", "%"+search+"%").getResultList();
    }

    public List<ObjectEntityDto> getUserObjects(String userId) {
        Connection con = null;
        List<ObjectEntityDto> userObjects = new ArrayList<>();

        try {
            con = DAOConnect.getInstance();
            if (con != null) {

                String sql = "SELECT * FROM object WHERE user_id = "
                        + userId;
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                ObjectEntityDto object;
                while(rs.next()) {
                    object = new ObjectEntityDto();
                    byte[] imgData = rs.getBytes("image");

                    String encode = Base64.getEncoder().encodeToString(imgData);
                    object.setId(rs.getString("id"));
                    object.setName(rs.getString("name"));
                    object.setDescription(rs.getString("description"));
                    object.setPrice(rs.getString("price"));
                    object.setEncode(encode);
                    userObjects.add(object);
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return userObjects;
    }

    public List<ObjectEntityDto> getAllObjects() {
        Connection con = null;
        List<ObjectEntityDto> userObjects = new ArrayList<>();

        try {
            con = DAOConnect.getInstance();
            if (con != null) {
                String sql = "SELECT * FROM object";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                ObjectEntityDto object;
                while(rs.next()) {
                    object = new ObjectEntityDto();
                    byte[] imgData = rs.getBytes("image");
                    String encode = Base64.getEncoder().encodeToString(imgData);
                    object.setId(rs.getString("id"));
                    object.setName(rs.getString("name"));
                    object.setDescription(rs.getString("description"));
                    object.setPrice(rs.getString("price"));
                    object.setUser(rs.getString("user_id"));
                    object.setEncode(encode);
                    userObjects.add(object);
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return userObjects;
    }

    public boolean addObject(ObjectEntityDto object, Part part) {
        Connection con = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            con = DAOConnect.getInstance();
            if (con != null) {
                String sql = "INSERT INTO object(user_id, name, description, price, image) VALUES(?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, object.getUser().getId());
                ps.setString(2, object.getName());
                ps.setString(3, object.getDescription());
                ps.setString(4, object.getPrice());
                ps.setBlob(5, part.getInputStream());
                i = ps.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return i > 0;
    }

    public boolean deleteObject(String objectId) {
        Connection con = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            con = DAOConnect.getInstance();
            if (con != null) {
                String sql = "DELETE FROM object WHERE id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, objectId);
                i = ps.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return i > 0;
    }
}
