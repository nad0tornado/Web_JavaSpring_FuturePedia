package com.futurepedia.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.futurepedia.models.Article;
import com.futurepedia.utils.MySQLJDBCUtil;

@RestController
public class ArticleController {
    @GetMapping("/articles")
    public Article[] GetArticles() {
        String query = "{ call GetArticles() }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection();
                CallableStatement stmt = conn.prepareCall(query)) {

            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s - %s - %s - %s",
                        rs.getString("Id") + " " +
                                rs.getString("Name"),
                        rs.getString("Content"),
                        rs.getString("DateAdded"),
                        rs.getString("LastModified")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Article[0];
    }

    @GetMapping("/articles/id")
    public Article GetArticleById(@RequestParam(value = "id") long id) {
        // Connection conn = DriverManager.getConnection("localhost:");

        return null;
    }

    @GetMapping("/articles/name")
    public Article GetArticleByName(@RequestParam(value = "name") String name) {
        // Connection conn = DriverManager.getConnection("localhost:");

        return null;
    }

    @PostMapping("/articles")
    public Article AddArticle() {
        // .. call "AddArticle" proc

        return null;
    }

    @PutMapping("/articles")
    public long UpdateArticle() {
        // .. call "UpdateArticle" proc

        return -1;
    }

    @DeleteMapping("/")
    public long DeleteArticle() {
        // .. call "DeleteArticle" proc

        return -1;
    }
}