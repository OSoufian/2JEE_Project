package com.supinfo.DAOFactories;

import com.supinfo.entities.UserEntityDto;

import java.util.List;

public interface UserEntityDAO {
    void add( UserEntityDto userEntityDto );
    List<UserEntityDto> lister();
}