package manage;

    public class QueryManage {


        private String query01 = "SELECT user_id FROM u168183796_qaloantec.deposits WHERE amount between 100 and 500;";
        private String query02 = "SELECT name FROM u168183796_qaloantec.cron_schedules Limit 2";

        //*********Getter**********
        public String getQuery01() {
            return query01;
        }

        public String getQuery02() {
            return query02;
        }
    }
