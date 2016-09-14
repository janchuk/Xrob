package com.theah64.xrob.api.database.tables.command;

import com.theah64.xrob.api.database.Connection;
import com.theah64.xrob.api.database.tables.BaseTable;
import com.theah64.xrob.api.models.Command;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by theapache64 on 15/9/16,1:36 AM.
 */
public class CommandStatuses extends BaseTable<Command.Status> {

    private CommandStatuses() {
    }

    private static final CommandStatuses instance = new CommandStatuses();

    public static CommandStatuses getInstance() {
        return instance;
    }

    @Override
    public void addv2(Command.Status status) throws RuntimeException {

        final String addClientQuery = "INSERT INTO command_statuses (command_id,status,status_message) VALUES (?,?,?);";
        final java.sql.Connection connection = Connection.getConnection();

        //To track the success

        try {
            final PreparedStatement ps = connection.prepareStatement(addClientQuery);

            ps.setString(1, client.getUsername());
            ps.setString(2, client.getPassHash());
            ps.setString(3, client.getApiKey());

            if (ps.executeUpdate() == 1) {
                final ResultSet rs = ps.getGeneratedKeys();
                if (rs.first()) {
                    clientId = rs.getString(1);
                }
                rs.close();
            }


            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}