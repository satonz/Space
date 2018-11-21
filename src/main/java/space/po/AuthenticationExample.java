package space.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthenticationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuthenticationExample() {
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

        public Criteria andInfIdIsNull() {
            addCriterion("inf_id is null");
            return (Criteria) this;
        }

        public Criteria andInfIdIsNotNull() {
            addCriterion("inf_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfIdEqualTo(Integer value) {
            addCriterion("inf_id =", value, "infId");
            return (Criteria) this;
        }

        public Criteria andInfIdNotEqualTo(Integer value) {
            addCriterion("inf_id <>", value, "infId");
            return (Criteria) this;
        }

        public Criteria andInfIdGreaterThan(Integer value) {
            addCriterion("inf_id >", value, "infId");
            return (Criteria) this;
        }

        public Criteria andInfIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("inf_id >=", value, "infId");
            return (Criteria) this;
        }

        public Criteria andInfIdLessThan(Integer value) {
            addCriterion("inf_id <", value, "infId");
            return (Criteria) this;
        }

        public Criteria andInfIdLessThanOrEqualTo(Integer value) {
            addCriterion("inf_id <=", value, "infId");
            return (Criteria) this;
        }

        public Criteria andInfIdIn(List<Integer> values) {
            addCriterion("inf_id in", values, "infId");
            return (Criteria) this;
        }

        public Criteria andInfIdNotIn(List<Integer> values) {
            addCriterion("inf_id not in", values, "infId");
            return (Criteria) this;
        }

        public Criteria andInfIdBetween(Integer value1, Integer value2) {
            addCriterion("inf_id between", value1, value2, "infId");
            return (Criteria) this;
        }

        public Criteria andInfIdNotBetween(Integer value1, Integer value2) {
            addCriterion("inf_id not between", value1, value2, "infId");
            return (Criteria) this;
        }

        public Criteria andInfTypeIsNull() {
            addCriterion("inf_type is null");
            return (Criteria) this;
        }

        public Criteria andInfTypeIsNotNull() {
            addCriterion("inf_type is not null");
            return (Criteria) this;
        }

        public Criteria andInfTypeEqualTo(Byte value) {
            addCriterion("inf_type =", value, "infType");
            return (Criteria) this;
        }

        public Criteria andInfTypeNotEqualTo(Byte value) {
            addCriterion("inf_type <>", value, "infType");
            return (Criteria) this;
        }

        public Criteria andInfTypeGreaterThan(Byte value) {
            addCriterion("inf_type >", value, "infType");
            return (Criteria) this;
        }

        public Criteria andInfTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("inf_type >=", value, "infType");
            return (Criteria) this;
        }

        public Criteria andInfTypeLessThan(Byte value) {
            addCriterion("inf_type <", value, "infType");
            return (Criteria) this;
        }

        public Criteria andInfTypeLessThanOrEqualTo(Byte value) {
            addCriterion("inf_type <=", value, "infType");
            return (Criteria) this;
        }

        public Criteria andInfTypeIn(List<Byte> values) {
            addCriterion("inf_type in", values, "infType");
            return (Criteria) this;
        }

        public Criteria andInfTypeNotIn(List<Byte> values) {
            addCriterion("inf_type not in", values, "infType");
            return (Criteria) this;
        }

        public Criteria andInfTypeBetween(Byte value1, Byte value2) {
            addCriterion("inf_type between", value1, value2, "infType");
            return (Criteria) this;
        }

        public Criteria andInfTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("inf_type not between", value1, value2, "infType");
            return (Criteria) this;
        }

        public Criteria andInfNameIsNull() {
            addCriterion("inf_name is null");
            return (Criteria) this;
        }

        public Criteria andInfNameIsNotNull() {
            addCriterion("inf_name is not null");
            return (Criteria) this;
        }

        public Criteria andInfNameEqualTo(String value) {
            addCriterion("inf_name =", value, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameNotEqualTo(String value) {
            addCriterion("inf_name <>", value, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameGreaterThan(String value) {
            addCriterion("inf_name >", value, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameGreaterThanOrEqualTo(String value) {
            addCriterion("inf_name >=", value, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameLessThan(String value) {
            addCriterion("inf_name <", value, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameLessThanOrEqualTo(String value) {
            addCriterion("inf_name <=", value, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameLike(String value) {
            addCriterion("inf_name like", value, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameNotLike(String value) {
            addCriterion("inf_name not like", value, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameIn(List<String> values) {
            addCriterion("inf_name in", values, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameNotIn(List<String> values) {
            addCriterion("inf_name not in", values, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameBetween(String value1, String value2) {
            addCriterion("inf_name between", value1, value2, "infName");
            return (Criteria) this;
        }

        public Criteria andInfNameNotBetween(String value1, String value2) {
            addCriterion("inf_name not between", value1, value2, "infName");
            return (Criteria) this;
        }

        public Criteria andInfTimeIsNull() {
            addCriterion("inf_time is null");
            return (Criteria) this;
        }

        public Criteria andInfTimeIsNotNull() {
            addCriterion("inf_time is not null");
            return (Criteria) this;
        }

        public Criteria andInfTimeEqualTo(Date value) {
            addCriterion("inf_time =", value, "infTime");
            return (Criteria) this;
        }

        public Criteria andInfTimeNotEqualTo(Date value) {
            addCriterion("inf_time <>", value, "infTime");
            return (Criteria) this;
        }

        public Criteria andInfTimeGreaterThan(Date value) {
            addCriterion("inf_time >", value, "infTime");
            return (Criteria) this;
        }

        public Criteria andInfTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("inf_time >=", value, "infTime");
            return (Criteria) this;
        }

        public Criteria andInfTimeLessThan(Date value) {
            addCriterion("inf_time <", value, "infTime");
            return (Criteria) this;
        }

        public Criteria andInfTimeLessThanOrEqualTo(Date value) {
            addCriterion("inf_time <=", value, "infTime");
            return (Criteria) this;
        }

        public Criteria andInfTimeIn(List<Date> values) {
            addCriterion("inf_time in", values, "infTime");
            return (Criteria) this;
        }

        public Criteria andInfTimeNotIn(List<Date> values) {
            addCriterion("inf_time not in", values, "infTime");
            return (Criteria) this;
        }

        public Criteria andInfTimeBetween(Date value1, Date value2) {
            addCriterion("inf_time between", value1, value2, "infTime");
            return (Criteria) this;
        }

        public Criteria andInfTimeNotBetween(Date value1, Date value2) {
            addCriterion("inf_time not between", value1, value2, "infTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andInfStatusIsNull() {
            addCriterion("inf_status is null");
            return (Criteria) this;
        }

        public Criteria andInfStatusIsNotNull() {
            addCriterion("inf_status is not null");
            return (Criteria) this;
        }

        public Criteria andInfStatusEqualTo(Boolean value) {
            addCriterion("inf_status =", value, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfStatusNotEqualTo(Boolean value) {
            addCriterion("inf_status <>", value, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfStatusGreaterThan(Boolean value) {
            addCriterion("inf_status >", value, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("inf_status >=", value, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfStatusLessThan(Boolean value) {
            addCriterion("inf_status <", value, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("inf_status <=", value, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfStatusIn(List<Boolean> values) {
            addCriterion("inf_status in", values, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfStatusNotIn(List<Boolean> values) {
            addCriterion("inf_status not in", values, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("inf_status between", value1, value2, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("inf_status not between", value1, value2, "infStatus");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedIsNull() {
            addCriterion("inf_is_dealed is null");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedIsNotNull() {
            addCriterion("inf_is_dealed is not null");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedEqualTo(Boolean value) {
            addCriterion("inf_is_dealed =", value, "infIsDealed");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedNotEqualTo(Boolean value) {
            addCriterion("inf_is_dealed <>", value, "infIsDealed");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedGreaterThan(Boolean value) {
            addCriterion("inf_is_dealed >", value, "infIsDealed");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("inf_is_dealed >=", value, "infIsDealed");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedLessThan(Boolean value) {
            addCriterion("inf_is_dealed <", value, "infIsDealed");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedLessThanOrEqualTo(Boolean value) {
            addCriterion("inf_is_dealed <=", value, "infIsDealed");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedIn(List<Boolean> values) {
            addCriterion("inf_is_dealed in", values, "infIsDealed");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedNotIn(List<Boolean> values) {
            addCriterion("inf_is_dealed not in", values, "infIsDealed");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedBetween(Boolean value1, Boolean value2) {
            addCriterion("inf_is_dealed between", value1, value2, "infIsDealed");
            return (Criteria) this;
        }

        public Criteria andInfIsDealedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("inf_is_dealed not between", value1, value2, "infIsDealed");
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