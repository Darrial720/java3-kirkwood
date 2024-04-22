package edu.kirkwood.learnx.data;

import edu.kirkwood.learnx.model.Course;
import edu.kirkwood.learnx.model.CourseCategory;
import edu.kirkwood.learnx.model.JobListing;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class JobListingDAO extends Database{
    public static void main(String[] args){
        try {
            getAll(5,0, "", "").forEach(System.out::println);
        }
        catch(Exception ex){
            System.out.println("List could not be created");
        }
    }

    public static List<JobListing> getAll(int p_limit, int p_offset, String p_department_name, String p_location){
        List<JobListing> jobListings = new ArrayList<>();
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{CALL sp_get_job_listings(?,?,?,?)}");
        ) {
            statement.setInt(1, p_limit);
            statement.setInt(2, p_offset);
            statement.setString(3, p_department_name);
            statement.setString(4, p_location);
            try(ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()) {
                    int job_id = resultSet.getInt("job_id");
                    int department_id = resultSet.getInt("department_id");
                    String department_name = resultSet.getString("department_name");
                    String position= resultSet.getString("position");
                    Instant posted_at = resultSet.getTimestamp("posted_at").toInstant();
                    String contract = resultSet.getString("contract");
                    String location = resultSet.getString("location");
                    String description = resultSet.getString("description");
                    boolean featured = resultSet.getBoolean("featured");
                    JobListing jobListing = new JobListing(job_id, department_id, department_name, featured, position, posted_at, contract, location, description);
                    jobListings.add(jobListing);
                }
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return jobListings;
    }
}
