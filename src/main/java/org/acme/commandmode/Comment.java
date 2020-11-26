package org.acme.commandmode;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Comment extends PanacheEntity {

    @NotBlank
    public String name;
    @NotBlank
    @Email
    @Column(unique = true)
    public String email;
    @NotBlank
    public String body;

    @Deprecated
    public Comment() {}

    public Comment(@NotBlank String name, @NotBlank @Email String email, @NotBlank String body) {
        this.name = name;
        this.email = email;
        this.body = body.substring(0, Math.min(body.length(), 250));
    }
}
