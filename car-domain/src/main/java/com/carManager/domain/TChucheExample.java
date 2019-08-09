package com.carManager.domain;

import java.util.ArrayList;
import java.util.List;

public class TChucheExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TChucheExample() {
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

        public Criteria andCheIdIsNull() {
            addCriterion("che_id is null");
            return (Criteria) this;
        }

        public Criteria andCheIdIsNotNull() {
            addCriterion("che_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheIdEqualTo(Integer value) {
            addCriterion("che_id =", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdNotEqualTo(Integer value) {
            addCriterion("che_id <>", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdGreaterThan(Integer value) {
            addCriterion("che_id >", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("che_id >=", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdLessThan(Integer value) {
            addCriterion("che_id <", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdLessThanOrEqualTo(Integer value) {
            addCriterion("che_id <=", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdIn(List<Integer> values) {
            addCriterion("che_id in", values, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdNotIn(List<Integer> values) {
            addCriterion("che_id not in", values, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdBetween(Integer value1, Integer value2) {
            addCriterion("che_id between", value1, value2, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdNotBetween(Integer value1, Integer value2) {
            addCriterion("che_id not between", value1, value2, "cheId");
            return (Criteria) this;
        }

        public Criteria andKaichushijianIsNull() {
            addCriterion("kaichushijian is null");
            return (Criteria) this;
        }

        public Criteria andKaichushijianIsNotNull() {
            addCriterion("kaichushijian is not null");
            return (Criteria) this;
        }

        public Criteria andKaichushijianEqualTo(String value) {
            addCriterion("kaichushijian =", value, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianNotEqualTo(String value) {
            addCriterion("kaichushijian <>", value, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianGreaterThan(String value) {
            addCriterion("kaichushijian >", value, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianGreaterThanOrEqualTo(String value) {
            addCriterion("kaichushijian >=", value, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianLessThan(String value) {
            addCriterion("kaichushijian <", value, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianLessThanOrEqualTo(String value) {
            addCriterion("kaichushijian <=", value, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianLike(String value) {
            addCriterion("kaichushijian like", value, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianNotLike(String value) {
            addCriterion("kaichushijian not like", value, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianIn(List<String> values) {
            addCriterion("kaichushijian in", values, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianNotIn(List<String> values) {
            addCriterion("kaichushijian not in", values, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianBetween(String value1, String value2) {
            addCriterion("kaichushijian between", value1, value2, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andKaichushijianNotBetween(String value1, String value2) {
            addCriterion("kaichushijian not between", value1, value2, "kaichushijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianIsNull() {
            addCriterion("huilaishijian is null");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianIsNotNull() {
            addCriterion("huilaishijian is not null");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianEqualTo(String value) {
            addCriterion("huilaishijian =", value, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianNotEqualTo(String value) {
            addCriterion("huilaishijian <>", value, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianGreaterThan(String value) {
            addCriterion("huilaishijian >", value, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianGreaterThanOrEqualTo(String value) {
            addCriterion("huilaishijian >=", value, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianLessThan(String value) {
            addCriterion("huilaishijian <", value, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianLessThanOrEqualTo(String value) {
            addCriterion("huilaishijian <=", value, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianLike(String value) {
            addCriterion("huilaishijian like", value, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianNotLike(String value) {
            addCriterion("huilaishijian not like", value, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianIn(List<String> values) {
            addCriterion("huilaishijian in", values, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianNotIn(List<String> values) {
            addCriterion("huilaishijian not in", values, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianBetween(String value1, String value2) {
            addCriterion("huilaishijian between", value1, value2, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andHuilaishijianNotBetween(String value1, String value2) {
            addCriterion("huilaishijian not between", value1, value2, "huilaishijian");
            return (Criteria) this;
        }

        public Criteria andShiyouIsNull() {
            addCriterion("shiyou is null");
            return (Criteria) this;
        }

        public Criteria andShiyouIsNotNull() {
            addCriterion("shiyou is not null");
            return (Criteria) this;
        }

        public Criteria andShiyouEqualTo(String value) {
            addCriterion("shiyou =", value, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouNotEqualTo(String value) {
            addCriterion("shiyou <>", value, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouGreaterThan(String value) {
            addCriterion("shiyou >", value, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouGreaterThanOrEqualTo(String value) {
            addCriterion("shiyou >=", value, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouLessThan(String value) {
            addCriterion("shiyou <", value, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouLessThanOrEqualTo(String value) {
            addCriterion("shiyou <=", value, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouLike(String value) {
            addCriterion("shiyou like", value, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouNotLike(String value) {
            addCriterion("shiyou not like", value, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouIn(List<String> values) {
            addCriterion("shiyou in", values, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouNotIn(List<String> values) {
            addCriterion("shiyou not in", values, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouBetween(String value1, String value2) {
            addCriterion("shiyou between", value1, value2, "shiyou");
            return (Criteria) this;
        }

        public Criteria andShiyouNotBetween(String value1, String value2) {
            addCriterion("shiyou not between", value1, value2, "shiyou");
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

        public Criteria andMudidizhiIsNull() {
            addCriterion("mudidizhi is null");
            return (Criteria) this;
        }

        public Criteria andMudidizhiIsNotNull() {
            addCriterion("mudidizhi is not null");
            return (Criteria) this;
        }

        public Criteria andMudidizhiEqualTo(String value) {
            addCriterion("mudidizhi =", value, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiNotEqualTo(String value) {
            addCriterion("mudidizhi <>", value, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiGreaterThan(String value) {
            addCriterion("mudidizhi >", value, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiGreaterThanOrEqualTo(String value) {
            addCriterion("mudidizhi >=", value, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiLessThan(String value) {
            addCriterion("mudidizhi <", value, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiLessThanOrEqualTo(String value) {
            addCriterion("mudidizhi <=", value, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiLike(String value) {
            addCriterion("mudidizhi like", value, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiNotLike(String value) {
            addCriterion("mudidizhi not like", value, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiIn(List<String> values) {
            addCriterion("mudidizhi in", values, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiNotIn(List<String> values) {
            addCriterion("mudidizhi not in", values, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiBetween(String value1, String value2) {
            addCriterion("mudidizhi between", value1, value2, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andMudidizhiNotBetween(String value1, String value2) {
            addCriterion("mudidizhi not between", value1, value2, "mudidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiIsNull() {
            addCriterion("qishidizhi is null");
            return (Criteria) this;
        }

        public Criteria andQishidizhiIsNotNull() {
            addCriterion("qishidizhi is not null");
            return (Criteria) this;
        }

        public Criteria andQishidizhiEqualTo(String value) {
            addCriterion("qishidizhi =", value, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiNotEqualTo(String value) {
            addCriterion("qishidizhi <>", value, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiGreaterThan(String value) {
            addCriterion("qishidizhi >", value, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiGreaterThanOrEqualTo(String value) {
            addCriterion("qishidizhi >=", value, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiLessThan(String value) {
            addCriterion("qishidizhi <", value, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiLessThanOrEqualTo(String value) {
            addCriterion("qishidizhi <=", value, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiLike(String value) {
            addCriterion("qishidizhi like", value, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiNotLike(String value) {
            addCriterion("qishidizhi not like", value, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiIn(List<String> values) {
            addCriterion("qishidizhi in", values, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiNotIn(List<String> values) {
            addCriterion("qishidizhi not in", values, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiBetween(String value1, String value2) {
            addCriterion("qishidizhi between", value1, value2, "qishidizhi");
            return (Criteria) this;
        }

        public Criteria andQishidizhiNotBetween(String value1, String value2) {
            addCriterion("qishidizhi not between", value1, value2, "qishidizhi");
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