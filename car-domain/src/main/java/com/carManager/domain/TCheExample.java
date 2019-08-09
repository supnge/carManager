package com.carManager.domain;

import java.util.ArrayList;
import java.util.List;

public class TCheExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCheExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChepaiIsNull() {
            addCriterion("chepai is null");
            return (Criteria) this;
        }

        public Criteria andChepaiIsNotNull() {
            addCriterion("chepai is not null");
            return (Criteria) this;
        }

        public Criteria andChepaiEqualTo(String value) {
            addCriterion("chepai =", value, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiNotEqualTo(String value) {
            addCriterion("chepai <>", value, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiGreaterThan(String value) {
            addCriterion("chepai >", value, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiGreaterThanOrEqualTo(String value) {
            addCriterion("chepai >=", value, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiLessThan(String value) {
            addCriterion("chepai <", value, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiLessThanOrEqualTo(String value) {
            addCriterion("chepai <=", value, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiLike(String value) {
            addCriterion("chepai like", value, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiNotLike(String value) {
            addCriterion("chepai not like", value, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiIn(List<String> values) {
            addCriterion("chepai in", values, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiNotIn(List<String> values) {
            addCriterion("chepai not in", values, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiBetween(String value1, String value2) {
            addCriterion("chepai between", value1, value2, "chepai");
            return (Criteria) this;
        }

        public Criteria andChepaiNotBetween(String value1, String value2) {
            addCriterion("chepai not between", value1, value2, "chepai");
            return (Criteria) this;
        }

        public Criteria andChexingIsNull() {
            addCriterion("chexing is null");
            return (Criteria) this;
        }

        public Criteria andChexingIsNotNull() {
            addCriterion("chexing is not null");
            return (Criteria) this;
        }

        public Criteria andChexingEqualTo(String value) {
            addCriterion("chexing =", value, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingNotEqualTo(String value) {
            addCriterion("chexing <>", value, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingGreaterThan(String value) {
            addCriterion("chexing >", value, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingGreaterThanOrEqualTo(String value) {
            addCriterion("chexing >=", value, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingLessThan(String value) {
            addCriterion("chexing <", value, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingLessThanOrEqualTo(String value) {
            addCriterion("chexing <=", value, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingLike(String value) {
            addCriterion("chexing like", value, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingNotLike(String value) {
            addCriterion("chexing not like", value, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingIn(List<String> values) {
            addCriterion("chexing in", values, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingNotIn(List<String> values) {
            addCriterion("chexing not in", values, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingBetween(String value1, String value2) {
            addCriterion("chexing between", value1, value2, "chexing");
            return (Criteria) this;
        }

        public Criteria andChexingNotBetween(String value1, String value2) {
            addCriterion("chexing not between", value1, value2, "chexing");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiIsNull() {
            addCriterion("chuchangriqi is null");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiIsNotNull() {
            addCriterion("chuchangriqi is not null");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiEqualTo(String value) {
            addCriterion("chuchangriqi =", value, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiNotEqualTo(String value) {
            addCriterion("chuchangriqi <>", value, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiGreaterThan(String value) {
            addCriterion("chuchangriqi >", value, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiGreaterThanOrEqualTo(String value) {
            addCriterion("chuchangriqi >=", value, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiLessThan(String value) {
            addCriterion("chuchangriqi <", value, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiLessThanOrEqualTo(String value) {
            addCriterion("chuchangriqi <=", value, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiLike(String value) {
            addCriterion("chuchangriqi like", value, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiNotLike(String value) {
            addCriterion("chuchangriqi not like", value, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiIn(List<String> values) {
            addCriterion("chuchangriqi in", values, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiNotIn(List<String> values) {
            addCriterion("chuchangriqi not in", values, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiBetween(String value1, String value2) {
            addCriterion("chuchangriqi between", value1, value2, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andChuchangriqiNotBetween(String value1, String value2) {
            addCriterion("chuchangriqi not between", value1, value2, "chuchangriqi");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangIsNull() {
            addCriterion("zaizhongliang is null");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangIsNotNull() {
            addCriterion("zaizhongliang is not null");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangEqualTo(String value) {
            addCriterion("zaizhongliang =", value, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangNotEqualTo(String value) {
            addCriterion("zaizhongliang <>", value, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangGreaterThan(String value) {
            addCriterion("zaizhongliang >", value, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangGreaterThanOrEqualTo(String value) {
            addCriterion("zaizhongliang >=", value, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangLessThan(String value) {
            addCriterion("zaizhongliang <", value, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangLessThanOrEqualTo(String value) {
            addCriterion("zaizhongliang <=", value, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangLike(String value) {
            addCriterion("zaizhongliang like", value, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangNotLike(String value) {
            addCriterion("zaizhongliang not like", value, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangIn(List<String> values) {
            addCriterion("zaizhongliang in", values, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangNotIn(List<String> values) {
            addCriterion("zaizhongliang not in", values, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangBetween(String value1, String value2) {
            addCriterion("zaizhongliang between", value1, value2, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andZaizhongliangNotBetween(String value1, String value2) {
            addCriterion("zaizhongliang not between", value1, value2, "zaizhongliang");
            return (Criteria) this;
        }

        public Criteria andSijiIdIsNull() {
            addCriterion("siji_id is null");
            return (Criteria) this;
        }

        public Criteria andSijiIdIsNotNull() {
            addCriterion("siji_id is not null");
            return (Criteria) this;
        }

        public Criteria andSijiIdEqualTo(Integer value) {
            addCriterion("siji_id =", value, "sijiId");
            return (Criteria) this;
        }

        public Criteria andSijiIdNotEqualTo(Integer value) {
            addCriterion("siji_id <>", value, "sijiId");
            return (Criteria) this;
        }

        public Criteria andSijiIdGreaterThan(Integer value) {
            addCriterion("siji_id >", value, "sijiId");
            return (Criteria) this;
        }

        public Criteria andSijiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("siji_id >=", value, "sijiId");
            return (Criteria) this;
        }

        public Criteria andSijiIdLessThan(Integer value) {
            addCriterion("siji_id <", value, "sijiId");
            return (Criteria) this;
        }

        public Criteria andSijiIdLessThanOrEqualTo(Integer value) {
            addCriterion("siji_id <=", value, "sijiId");
            return (Criteria) this;
        }

        public Criteria andSijiIdIn(List<Integer> values) {
            addCriterion("siji_id in", values, "sijiId");
            return (Criteria) this;
        }

        public Criteria andSijiIdNotIn(List<Integer> values) {
            addCriterion("siji_id not in", values, "sijiId");
            return (Criteria) this;
        }

        public Criteria andSijiIdBetween(Integer value1, Integer value2) {
            addCriterion("siji_id between", value1, value2, "sijiId");
            return (Criteria) this;
        }

        public Criteria andSijiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("siji_id not between", value1, value2, "sijiId");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingIsNull() {
            addCriterion("shiyouleixing is null");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingIsNotNull() {
            addCriterion("shiyouleixing is not null");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingEqualTo(String value) {
            addCriterion("shiyouleixing =", value, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingNotEqualTo(String value) {
            addCriterion("shiyouleixing <>", value, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingGreaterThan(String value) {
            addCriterion("shiyouleixing >", value, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingGreaterThanOrEqualTo(String value) {
            addCriterion("shiyouleixing >=", value, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingLessThan(String value) {
            addCriterion("shiyouleixing <", value, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingLessThanOrEqualTo(String value) {
            addCriterion("shiyouleixing <=", value, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingLike(String value) {
            addCriterion("shiyouleixing like", value, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingNotLike(String value) {
            addCriterion("shiyouleixing not like", value, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingIn(List<String> values) {
            addCriterion("shiyouleixing in", values, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingNotIn(List<String> values) {
            addCriterion("shiyouleixing not in", values, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingBetween(String value1, String value2) {
            addCriterion("shiyouleixing between", value1, value2, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andShiyouleixingNotBetween(String value1, String value2) {
            addCriterion("shiyouleixing not between", value1, value2, "shiyouleixing");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(String value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(String value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(String value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(String value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(String value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(String value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLike(String value) {
            addCriterion("del like", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotLike(String value) {
            addCriterion("del not like", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<String> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<String> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(String value1, String value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(String value1, String value2) {
            addCriterion("del not between", value1, value2, "del");
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