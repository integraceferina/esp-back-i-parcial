package com.dh.SecurityOAuth.services;


import com.dh.SecurityOAuth.models.User;

public interface IEntityService {

    /* ================== Métodos ================== */
    User findByUsername(String username);
    User update(Long id, User user);

}
