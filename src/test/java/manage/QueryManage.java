package manage;

import utilities.JDBCReusableMethods;

public class QueryManage {

        private String query01 = "SELECT user_id FROM u168183796_qaloantec.deposits WHERE amount BETWEEN ? AND ?";
        private String query02 = "SELECT name FROM u168183796_qaloantec.cron_schedules LIMIT 2";
        private String query03 = "SELECT firstname,lastname FROM users WHERE country_code NOT LIKE 'TR' AND id=11";
        private String query04 = "SELECT user_id, GROUP_CONCAT(browser, ' - ', os) AS browser_os FROM user_logins GROUP BY user_id";
        private String UpdateQuery05 = "UPDATE users SET mobile= 987654321 WHERE username LIKE '%e_'";
        private String preparedQuery05 = "UPDATE users SET mobile= ? WHERE username LIKE ?";
        private String preparedQuery06 = "INSERT INTO admin_password_resets (id, email, token, status) VALUES (?, ?, ?, ?)";
        private String preparedQuery07 = "UPDATE admin_notifications SET is_read = ? WHERE id = ? ";



    //*********Getter**********
        public String getQuery01() {
            return query01;
        }
        public String getQuery02() {
            return query02;
        }
        public String getQuery03() {
            return query03;
        }
        public String getQuery04() {
            return query04;
        }
        public String getUpdateQuery05() {
            return UpdateQuery05;
        }
        public String getPreparedQuery05() {
            return preparedQuery05;
        }
        public String getPreparedQuery06() {
            return preparedQuery06;
        }
        public String getPreparedQuery07() {
        return preparedQuery07;
    }
}
