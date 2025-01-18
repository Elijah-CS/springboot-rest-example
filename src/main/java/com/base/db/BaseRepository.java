package com.base.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.objects.AuditModel;


@Repository
public interface BaseRepository<T extends AuditModel> extends JpaRepository<T, String> {}