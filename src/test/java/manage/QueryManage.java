package manage;

public class QueryManage {

        private String query01 = "SELECT user_id FROM u168183796_qaloantec.deposits WHERE amount BETWEEN ? AND ?";
        private String query02 = "SELECT name FROM u168183796_qaloantec.cron_schedules LIMIT 2";
        private String query03 = "SELECT firstname,lastname FROM users WHERE country_code NOT LIKE 'TR' AND id=11";
        private String query04 = "SELECT user_id, GROUP_CONCAT(browser, ' - ', os) AS browser_os FROM user_logins GROUP BY user_id";
        private String UpdateQuery05 = "UPDATE users SET mobile= 987654321 WHERE username LIKE '%e_'";
        private String updatePreparedQuery05 = "UPDATE users SET mobile= ? WHERE username LIKE ?";
        private String insertPreparedQuery06 = "INSERT INTO admin_password_resets (id, email, token, status, created_at) VALUES (?, ?, ?, ?, ?)";
        private String Query06 = "SELECT id FROM admin_password_resets";
        private String updatepreparedQuery07 = "UPDATE admin_notifications SET is_read = ? WHERE id = ? ";
        private String insertPreparedQuery08 = "INSERT INTO update_logs (id, version, update_log, created_at) VALUES(?, ?, ?, ?)";
        private String Query08 = "SELECT id FROM update_logs";
        private String updatePreparedQuery08 = "UPDATE update_logs SET update_log = ? WHERE version = ? AND id = ?";
        private String DeletePreparedQuery09 = "DELETE FROM update_logs WHERE id = ?";
        private String insertPreparedQuery10 = "INSERT INTO support_attachments (id, support_message_id, attachment, created_at) VALUES(?, ?, ?, ?)";
        private String Query10 = "SELECT id FROM support_attachments";
        private String deletePreparedQuery10 = "DELETE FROM support_attachments WHERE support_message_id = ?";
        private String practiceQuery01 = "SELECT remember_token FROM admins WHERE email = ?";
        private String practiceQuery02 = "SELECT charge FROM deposits WHERE amount < ? AND trx = ?";
        private String practiceQuery03 = "INSERT INTO admin_password_resets (id, email, token, status, created_at) VALUES(?, ?, ?, ?, ?)";
        private String practiceQuery04 = "SELECT support_ticket_id FROM support_messages WHERE message = ?";
        private String practiceQuery05 = "SELECT subject FROM support_tickets WHERE ticket LIKE ?";
        private String practiceQuery06ID = "SELECT id FROM loans";
        private String practiceQuery06 = "INSERT INTO loans (id, loan_number, user_id, plan_id, amount) VALUES(?, ?, ?, ?, ?)";
        private String practiceQuery06Delete = "DELETE FROM loans WHERE loan_number = ?";
        private String practiceQuery07 = "";
        private String practiceQuery08 = "";
        private String practiceQuery09 = "";
        private String practiceQuery10 = "";
        private String practiceQuery11 = "";
        private String practiceQuery12 = "";
        private String practiceQuery13 = "";
        private String practiceQuery14 = "";
        private String practiceQuery15 = "";
        private String practiceQuery16 = "";
        private String practiceQuery17 = "";
        private String practiceQuery18 = "";
        private String practiceQuery19 = "";
        private String practiceQuery20 = "";
        private String practiceQuery21 = "";
        private String practiceQuery22 = "";

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
        public String getUpdatePreparedQuery05() {
            return updatePreparedQuery05;
        }
        public String getInsertPreparedQuery06() {
            return insertPreparedQuery06;
        }
        public String getUpdatepreparedQuery07() {
        return updatepreparedQuery07;
    }
        public String getInsertPreparedQuery08() {
        return insertPreparedQuery08;
    }
        public String getUpdatePreparedQuery08() {
        return updatePreparedQuery08;
    }
        public String getDeletePreparedQuery09() {
            return DeletePreparedQuery09;
        }
        public String getInsertPreparedQuery10() {
            return insertPreparedQuery10;
        }
        public String getDeletePreparedQuery10() {
            return deletePreparedQuery10;
        }
        public String getPracticeQuery01() {
            return practiceQuery01;
        }
        public String getPracticeQuery02() {
            return practiceQuery02;
        }
        public String getPracticeQuery03() {
            return practiceQuery03;
        }
        public String getPracticeQuery04() {
            return practiceQuery04;
        }
        public String getPracticeQuery05() {
            return practiceQuery05;
        }
        public String getPracticeQuery06() {
            return practiceQuery06;
        }
        public String getPracticeQuery07() {
            return practiceQuery07;
        }
        public String getPracticeQuery08() {
            return practiceQuery08;
        }
        public String getPracticeQuery09() {
            return practiceQuery09;
        }
        public String getPracticeQuery10() {
            return practiceQuery10;
        }
        public String getPracticeQuery11() {
            return practiceQuery11;
        }
        public String getPracticeQuery12() {
            return practiceQuery12;
        }
        public String getPracticeQuery13() {
            return practiceQuery13;
        }
        public String getPracticeQuery14() {
            return practiceQuery14;
        }
        public String getPracticeQuery15() {
            return practiceQuery15;
        }
        public String getPracticeQuery16() {
            return practiceQuery16;
        }
        public String getPracticeQuery17() {
            return practiceQuery17;
        }
        public String getPracticeQuery18() {
            return practiceQuery18;
        }
        public String getPracticeQuery19() {
            return practiceQuery19;
        }
        public String getPracticeQuery20() {
            return practiceQuery20;
        }
        public String getPracticeQuery21() {
            return practiceQuery21;
        }
        public String getPracticeQuery22() {
            return practiceQuery22;
        }

    public String getQuery08() {
        return Query08;
    }

    public String getQuery06() {
        return Query06;
    }

    public String getQuery10() {
        return Query10;
    }

    public String getPracticeQuery06ID() {
        return practiceQuery06ID;
    }

    public String getPracticeQuery06Delete() {
        return practiceQuery06Delete;
    }
}
