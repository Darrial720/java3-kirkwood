package edu.kirkwood.learnx.data;



import edu.kirkwood.learnx.model.Course;
import edu.kirkwood.learnx.model.JobApplication;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobApplicationDAO extends Database{
    public static boolean createJobApplication(JobApplication jobApplication) {
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall("{CALL sp_add_job_application(?, ?, ?, ?, ?, ?)}")
        ) {
            statement.setInt(1, jobApplication.getJob_id());
            statement.setString(2, jobApplication.getFirstName());
            statement.setString(3, jobApplication.getLastName());
            statement.setString(4, jobApplication.getEmail());
            statement.setDouble(5, jobApplication.getDesiredSalary());
            //Timestamp timestamp = Timestamp.from(jobApplication.getEarliestStartDate());
            statement.setTimestamp(6, Timestamp.from(Instant.parse(jobApplication.getEarliestStartDate().toString())));
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            System.out.println("Job Application not created");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static List<JobApplication> getAll() {
        List<JobApplication> jobApplications = new ArrayList<>();
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{CALL sp_get_all_job_applications()}");
        ) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()) {
                    int id = resultSet.getInt("applicationId");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String email = resultSet.getString("email");
                    double desiredSalary = resultSet.getDouble("desiredSalary");
                    LocalDate earliestStartDate = resultSet.getTimestamp("earliestStartDate").toLocalDateTime().toLocalDate();
                    Instant dateSubmitted = resultSet.getTimestamp("dateSubmitted").toInstant();
                    String status = resultSet.getString("status");
                    int job_id = resultSet.getInt("job_id");
                    JobApplication jobApplication = new JobApplication(id, job_id, firstName, lastName, email, desiredSalary, earliestStartDate, dateSubmitted,status);
                    jobApplications.add(jobApplication);
                }
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return jobApplications;
    }
}
