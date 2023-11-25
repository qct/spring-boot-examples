/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables.records;

import alex.jooq.tables.QrtzCalendars;
import jakarta.annotation.Generated;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

/** This class is generated by jOOQ. */
@Generated(
        value = {"http://www.jooq.org", "jOOQ version:3.10.7"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class QrtzCalendarsRecord extends UpdatableRecordImpl<QrtzCalendarsRecord>
        implements Record3<String, String, byte[]> {

    private static final long serialVersionUID = 339752657;

    /** Setter for <code>test.qrtz_calendars.SCHED_NAME</code>. */
    public void setSchedName(String value) {
        set(0, value);
    }

    /** Getter for <code>test.qrtz_calendars.SCHED_NAME</code>. */
    public String getSchedName() {
        return (String) get(0);
    }

    /** Setter for <code>test.qrtz_calendars.CALENDAR_NAME</code>. */
    public void setCalendarName(String value) {
        set(1, value);
    }

    /** Getter for <code>test.qrtz_calendars.CALENDAR_NAME</code>. */
    public String getCalendarName() {
        return (String) get(1);
    }

    /** Setter for <code>test.qrtz_calendars.CALENDAR</code>. */
    public void setCalendar(byte... value) {
        set(2, value);
    }

    /** Getter for <code>test.qrtz_calendars.CALENDAR</code>. */
    public byte[] getCalendar() {
        return (byte[]) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public Row3<String, String, byte[]> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /** {@inheritDoc} */
    @Override
    public Row3<String, String, byte[]> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field1() {
        return QrtzCalendars.QRTZ_CALENDARS.SCHED_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<String> field2() {
        return QrtzCalendars.QRTZ_CALENDARS.CALENDAR_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public Field<byte[]> field3() {
        return QrtzCalendars.QRTZ_CALENDARS.CALENDAR;
    }

    /** {@inheritDoc} */
    @Override
    public String component1() {
        return getSchedName();
    }

    /** {@inheritDoc} */
    @Override
    public String component2() {
        return getCalendarName();
    }

    /** {@inheritDoc} */
    @Override
    public byte[] component3() {
        return getCalendar();
    }

    /** {@inheritDoc} */
    @Override
    public String value1() {
        return getSchedName();
    }

    /** {@inheritDoc} */
    @Override
    public String value2() {
        return getCalendarName();
    }

    /** {@inheritDoc} */
    @Override
    public byte[] value3() {
        return getCalendar();
    }

    /** {@inheritDoc} */
    @Override
    public QrtzCalendarsRecord value1(String value) {
        setSchedName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzCalendarsRecord value2(String value) {
        setCalendarName(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzCalendarsRecord value3(byte... value) {
        setCalendar(value);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public QrtzCalendarsRecord values(String value1, String value2, byte[] value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /** Create a detached QrtzCalendarsRecord */
    public QrtzCalendarsRecord() {
        super(QrtzCalendars.QRTZ_CALENDARS);
    }

    /** Create a detached, initialised QrtzCalendarsRecord */
    public QrtzCalendarsRecord(String schedName, String calendarName, byte[] calendar) {
        super(QrtzCalendars.QRTZ_CALENDARS);

        set(0, schedName);
        set(1, calendarName);
        set(2, calendar);
    }
}
