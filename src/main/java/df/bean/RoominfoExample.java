package df.bean;

import java.util.ArrayList;
import java.util.List;

public class RoominfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoominfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRoomidIsNull() {
            addCriterion("roomId is null");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNotNull() {
            addCriterion("roomId is not null");
            return (Criteria) this;
        }

        public Criteria andRoomidEqualTo(Integer value) {
            addCriterion("roomId =", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotEqualTo(Integer value) {
            addCriterion("roomId <>", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThan(Integer value) {
            addCriterion("roomId >", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomId >=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThan(Integer value) {
            addCriterion("roomId <", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThanOrEqualTo(Integer value) {
            addCriterion("roomId <=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidIn(List<Integer> values) {
            addCriterion("roomId in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotIn(List<Integer> values) {
            addCriterion("roomId not in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidBetween(Integer value1, Integer value2) {
            addCriterion("roomId between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotBetween(Integer value1, Integer value2) {
            addCriterion("roomId not between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andZbnameIsNull() {
            addCriterion("zbName is null");
            return (Criteria) this;
        }

        public Criteria andZbnameIsNotNull() {
            addCriterion("zbName is not null");
            return (Criteria) this;
        }

        public Criteria andZbnameEqualTo(String value) {
            addCriterion("zbName =", value, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameNotEqualTo(String value) {
            addCriterion("zbName <>", value, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameGreaterThan(String value) {
            addCriterion("zbName >", value, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameGreaterThanOrEqualTo(String value) {
            addCriterion("zbName >=", value, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameLessThan(String value) {
            addCriterion("zbName <", value, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameLessThanOrEqualTo(String value) {
            addCriterion("zbName <=", value, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameLike(String value) {
            addCriterion("zbName like", value, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameNotLike(String value) {
            addCriterion("zbName not like", value, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameIn(List<String> values) {
            addCriterion("zbName in", values, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameNotIn(List<String> values) {
            addCriterion("zbName not in", values, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameBetween(String value1, String value2) {
            addCriterion("zbName between", value1, value2, "zbname");
            return (Criteria) this;
        }

        public Criteria andZbnameNotBetween(String value1, String value2) {
            addCriterion("zbName not between", value1, value2, "zbname");
            return (Criteria) this;
        }

        public Criteria andLivetypeIsNull() {
            addCriterion("liveType is null");
            return (Criteria) this;
        }

        public Criteria andLivetypeIsNotNull() {
            addCriterion("liveType is not null");
            return (Criteria) this;
        }

        public Criteria andLivetypeEqualTo(String value) {
            addCriterion("liveType =", value, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeNotEqualTo(String value) {
            addCriterion("liveType <>", value, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeGreaterThan(String value) {
            addCriterion("liveType >", value, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeGreaterThanOrEqualTo(String value) {
            addCriterion("liveType >=", value, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeLessThan(String value) {
            addCriterion("liveType <", value, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeLessThanOrEqualTo(String value) {
            addCriterion("liveType <=", value, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeLike(String value) {
            addCriterion("liveType like", value, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeNotLike(String value) {
            addCriterion("liveType not like", value, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeIn(List<String> values) {
            addCriterion("liveType in", values, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeNotIn(List<String> values) {
            addCriterion("liveType not in", values, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeBetween(String value1, String value2) {
            addCriterion("liveType between", value1, value2, "livetype");
            return (Criteria) this;
        }

        public Criteria andLivetypeNotBetween(String value1, String value2) {
            addCriterion("liveType not between", value1, value2, "livetype");
            return (Criteria) this;
        }

        public Criteria andStasticscountIsNull() {
            addCriterion("stasticscount is null");
            return (Criteria) this;
        }

        public Criteria andStasticscountIsNotNull() {
            addCriterion("stasticscount is not null");
            return (Criteria) this;
        }

        public Criteria andStasticscountEqualTo(Integer value) {
            addCriterion("stasticscount =", value, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andStasticscountNotEqualTo(Integer value) {
            addCriterion("stasticscount <>", value, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andStasticscountGreaterThan(Integer value) {
            addCriterion("stasticscount >", value, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andStasticscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stasticscount >=", value, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andStasticscountLessThan(Integer value) {
            addCriterion("stasticscount <", value, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andStasticscountLessThanOrEqualTo(Integer value) {
            addCriterion("stasticscount <=", value, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andStasticscountIn(List<Integer> values) {
            addCriterion("stasticscount in", values, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andStasticscountNotIn(List<Integer> values) {
            addCriterion("stasticscount not in", values, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andStasticscountBetween(Integer value1, Integer value2) {
            addCriterion("stasticscount between", value1, value2, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andStasticscountNotBetween(Integer value1, Integer value2) {
            addCriterion("stasticscount not between", value1, value2, "stasticscount");
            return (Criteria) this;
        }

        public Criteria andRoomurlIsNull() {
            addCriterion("roomUrl is null");
            return (Criteria) this;
        }

        public Criteria andRoomurlIsNotNull() {
            addCriterion("roomUrl is not null");
            return (Criteria) this;
        }

        public Criteria andRoomurlEqualTo(String value) {
            addCriterion("roomUrl =", value, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlNotEqualTo(String value) {
            addCriterion("roomUrl <>", value, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlGreaterThan(String value) {
            addCriterion("roomUrl >", value, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlGreaterThanOrEqualTo(String value) {
            addCriterion("roomUrl >=", value, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlLessThan(String value) {
            addCriterion("roomUrl <", value, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlLessThanOrEqualTo(String value) {
            addCriterion("roomUrl <=", value, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlLike(String value) {
            addCriterion("roomUrl like", value, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlNotLike(String value) {
            addCriterion("roomUrl not like", value, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlIn(List<String> values) {
            addCriterion("roomUrl in", values, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlNotIn(List<String> values) {
            addCriterion("roomUrl not in", values, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlBetween(String value1, String value2) {
            addCriterion("roomUrl between", value1, value2, "roomurl");
            return (Criteria) this;
        }

        public Criteria andRoomurlNotBetween(String value1, String value2) {
            addCriterion("roomUrl not between", value1, value2, "roomurl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}