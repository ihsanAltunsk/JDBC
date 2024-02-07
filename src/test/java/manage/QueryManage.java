package manage;

    public class QueryManage {


        private String query01 = "SELECT user_id FROM u168183796_qaloantec.deposits WHERE amount between 100 and 500";
        private String query02 = "SELECT name FROM u168183796_qaloantec.cron_schedules Limit 2";
        private String query03 = "SELECT firstname,lastname FROM users WHERE country_code NOT LIKE 'TR' AND id=11";
        private String query04 = "SELECT user_id, group_concat(browser, ' - ', os) AS browser_os FROM user_logins GROUP BY user_id";
        private String query05 = "UPDATE users SET mobile=123456789 WHERE username LIKE ‘%e_’";

        //*********Getter**********
        public String getQuery01() {
            return query01;
        }
        public String getQuery02() {
            return query02;
        }
        public String getQuery03() {return query03;}
        public String getQuery04() {return query04;}

        public String getQuery05() {return query05;}
    }
