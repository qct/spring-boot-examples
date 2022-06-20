/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables.records;

import alex.jooq.tables.QrtzSimpropTriggers;
import java.math.BigDecimal;
import javax.annotation.Generated;
import org.jooq.Field;
import org.jooq.Record14;
import org.jooq.Record3;
import org.jooq.Row14;
import org.jooq.impl.UpdatableRecordImpl;

/** This class is generated by jOOQ. */
@Generated(
        value = {"http://www.jooq.org", "jOOQ version:3.10.7"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class QrtzSimpropTriggersRecord extends UpdatableRecordImpl<QrtzSimpropTriggersRecord>
        implements Record14<
                String,
                String,
                String,
                String,
                String,
                String,
                Integer,
                Integer,
                Long,
                Long,
                BigDecimal,
                BigDecimal,
                String,
                String> {

    private static final long serialVersionUID = -1962478175;

    /** Setter for <code>test.qrtz_simprop_triggers.SCHED_NAME</code>. */
    public void setSchedName(String value) {
        set(0, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.SCHED_NAME</code>. */
    public String getSchedName() {
        return (String) get(0);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.TRIGGER_NAME</code>. */
    public void setTriggerName(String value) {
        set(1, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.TRIGGER_NAME</code>. */
    public String getTriggerName() {
        return (String) get(1);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.TRIGGER_GROUP</code>. */
    public void setTriggerGroup(String value) {
        set(2, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.TRIGGER_GROUP</code>. */
    public String getTriggerGroup() {
        return (String) get(2);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.STR_PROP_1</code>. */
    public void setStrProp_1(String value) {
        set(3, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.STR_PROP_1</code>. */
    public String getStrProp_1() {
        return (String) get(3);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.STR_PROP_2</code>. */
    public void setStrProp_2(String value) {
        set(4, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.STR_PROP_2</code>. */
    public String getStrProp_2() {
        return (String) get(4);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.STR_PROP_3</code>. */
    public void setStrProp_3(String value) {
        set(5, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.STR_PROP_3</code>. */
    public String getStrProp_3() {
        return (String) get(5);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.INT_PROP_1</code>. */
    public void setIntProp_1(Integer value) {
        set(6, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.INT_PROP_1</code>. */
    public Integer getIntProp_1() {
        return (Integer) get(6);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.INT_PROP_2</code>. */
    public void setIntProp_2(Integer value) {
        set(7, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.INT_PROP_2</code>. */
    public Integer getIntProp_2() {
        return (Integer) get(7);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.LONG_PROP_1</code>. */
    public void setLongProp_1(Long value) {
        set(8, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.LONG_PROP_1</code>. */
    public Long getLongProp_1() {
        return (Long) get(8);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.LONG_PROP_2</code>. */
    public void setLongProp_2(Long value) {
        set(9, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.LONG_PROP_2</code>. */
    public Long getLongProp_2() {
        return (Long) get(9);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.DEC_PROP_1</code>. */
    public void setDecProp_1(BigDecimal value) {
        set(10, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.DEC_PROP_1</code>. */
    public BigDecimal getDecProp_1() {
        return (BigDecimal) get(10);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.DEC_PROP_2</code>. */
    public void setDecProp_2(BigDecimal value) {
        set(11, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.DEC_PROP_2</code>. */
    public BigDecimal getDecProp_2() {
        return (BigDecimal) get(11);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.BOOL_PROP_1</code>. */
    public void setBoolProp_1(String value) {
        set(12, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.BOOL_PROP_1</code>. */
    public String getBoolProp_1() {
        return (String) get(12);
    }

    /** Setter for <code>test.qrtz_simprop_triggers.BOOL_PROP_2</code>. */
    public void setBoolProp_2(String value) {
        set(13, value);
    }

    /** Getter for <code>test.qrtz_simprop_triggers.BOOL_PROP_2</code>. */
    public String getBoolProp_2() {
        return (String) get(13);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Record3<String, String, String> key() {
        return (Record3) super.key();
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Row14<
                    String,
                    String,
                    String,
                    String,
                    String,
                    String,
                    Integer,
                    Integer,
                    Long,
                    Long,
                    BigDecimal,
                    BigDecimal,
                    String,
                    String>
            fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /** {@inheritDoc} */
    @Override
    public Row14<
                    String,
                    String,
                    String,
                    String,
                    String,
                    String,
                    Integer,
                    Integer,
                    Long,
                    Long,
                    BigDecimal,
                    BigDecimal,
                    String,
                    String>
            valuesRow() {
        return (Row14) super.valuesRow();
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field1() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.SCHED_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field2() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.TRIGGER_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field3() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.TRIGGER_GROUP;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field4() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.STR_PROP_1;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field5() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.STR_PROP_2;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field6() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.STR_PROP_3;
    }

    /** {@inheritDoc} */
    @Override
    public Field<Integer> field7() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.INT_PROP_1;
    }

    /** {@inheritDoc} */
    @Override
    public Field<Integer> field8() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.INT_PROP_2;
    }

    /** {@inheritDoc} */
    @Override
    public Field<Long> field9() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.LONG_PROP_1;
    }

    /** {@inheritDoc} */
    @Override
    public Field<Long> field10() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.LONG_PROP_2;
    }

    /** {@inheritDoc} */
    @Override
    public Field<BigDecimal> field11() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.DEC_PROP_1;
    }

    /** {@inheritDoc} */
    @Override
    public Field<BigDecimal> field12() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.DEC_PROP_2;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field13() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.BOOL_PROP_1;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field14() {
        return QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS.BOOL_PROP_2;
    }

    /** {@inheritDoc} */
    @Override
    public String component1() {
        return getSchedName();
    }

    /** {@inheritDoc} */
    @Override
    public String component2() {
        return getTriggerName();
    }

    /** {@inheritDoc} */
    @Override
    public String component3() {
        return getTriggerGroup();
    }

    /** {@inheritDoc} */
    @Override
    public String component4() {
        return getStrProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public String component5() {
        return getStrProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public String component6() {
        return getStrProp_3();
    }

    /** {@inheritDoc} */
    @Override
    public Integer component7() {
        return getIntProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public Integer component8() {
        return getIntProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public Long component9() {
        return getLongProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public Long component10() {
        return getLongProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public BigDecimal component11() {
        return getDecProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public BigDecimal component12() {
        return getDecProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public String component13() {
        return getBoolProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public String component14() {
        return getBoolProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public String value1() {
        return getSchedName();
    }

    /** {@inheritDoc} */
    @Override
    public String value2() {
        return getTriggerName();
    }

    /** {@inheritDoc} */
    @Override
    public String value3() {
        return getTriggerGroup();
    }

    /** {@inheritDoc} */
    @Override
    public String value4() {
        return getStrProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public String value5() {
        return getStrProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public String value6() {
        return getStrProp_3();
    }

    /** {@inheritDoc} */
    @Override
    public Integer value7() {
        return getIntProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public Integer value8() {
        return getIntProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public Long value9() {
        return getLongProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public Long value10() {
        return getLongProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public BigDecimal value11() {
        return getDecProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public BigDecimal value12() {
        return getDecProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public String value13() {
        return getBoolProp_1();
    }

    /** {@inheritDoc} */
    @Override
    public String value14() {
        return getBoolProp_2();
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value1(String value) {
        setSchedName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value2(String value) {
        setTriggerName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value3(String value) {
        setTriggerGroup(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value4(String value) {
        setStrProp_1(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value5(String value) {
        setStrProp_2(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value6(String value) {
        setStrProp_3(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value7(Integer value) {
        setIntProp_1(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value8(Integer value) {
        setIntProp_2(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value9(Long value) {
        setLongProp_1(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value10(Long value) {
        setLongProp_2(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value11(BigDecimal value) {
        setDecProp_1(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value12(BigDecimal value) {
        setDecProp_2(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value13(String value) {
        setBoolProp_1(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord value14(String value) {
        setBoolProp_2(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzSimpropTriggersRecord values(
            String value1,
            String value2,
            String value3,
            String value4,
            String value5,
            String value6,
            Integer value7,
            Integer value8,
            Long value9,
            Long value10,
            BigDecimal value11,
            BigDecimal value12,
            String value13,
            String value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /** Create a detached QrtzSimpropTriggersRecord */
    public QrtzSimpropTriggersRecord() {
        super(QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS);
    }

    /** Create a detached, initialised QrtzSimpropTriggersRecord */
    public QrtzSimpropTriggersRecord(
            String schedName,
            String triggerName,
            String triggerGroup,
            String strProp_1,
            String strProp_2,
            String strProp_3,
            Integer intProp_1,
            Integer intProp_2,
            Long longProp_1,
            Long longProp_2,
            BigDecimal decProp_1,
            BigDecimal decProp_2,
            String boolProp_1,
            String boolProp_2) {
        super(QrtzSimpropTriggers.QRTZ_SIMPROP_TRIGGERS);

        set(0, schedName);
        set(1, triggerName);
        set(2, triggerGroup);
        set(3, strProp_1);
        set(4, strProp_2);
        set(5, strProp_3);
        set(6, intProp_1);
        set(7, intProp_2);
        set(8, longProp_1);
        set(9, longProp_2);
        set(10, decProp_1);
        set(11, decProp_2);
        set(12, boolProp_1);
        set(13, boolProp_2);
    }
}
