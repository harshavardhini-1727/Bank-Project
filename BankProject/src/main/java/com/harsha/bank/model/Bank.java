package com.harsha.bank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bank {

    public void createAccount(Account account) {

        String sql = "INSERT INTO account (account_number, account_holder_name, balance) VALUES (?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, account.getAccountNumber());
            ps.setString(2, account.getAccountHolderName());
            ps.setInt(3, account.getBalance());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account searchAccount(int accountNumber) {

        String sql = "SELECT * FROM account WHERE account_number = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(
                        rs.getInt("account_number"),
                        rs.getString("account_holder_name"),
                        rs.getInt("balance")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteAccount(int accountNumber) {

        String sql = "DELETE FROM account WHERE account_number = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accountNumber);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayAllAccount() {

        String sql = "SELECT * FROM account";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Account No: " + rs.getInt("account_number"));
                System.out.println("Name: " + rs.getString("account_holder_name"));
                System.out.println("Balance: " + rs.getInt("balance"));
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}