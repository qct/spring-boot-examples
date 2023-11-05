/*
 * This file is generated by jOOQ.
 */
package alex.jooq.tables;

import alex.jooq.Indexes;
import alex.jooq.Keys;
import alex.jooq.Test;
import alex.jooq.tables.records.QrtzCalendarsRecord;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

/** This class is generated by jOOQ. */
@Generated(
        value = {"http://www.jooq.org", "jOOQ version:3.10.7"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class QrtzCalendars extends TableImpl<QrtzCalendarsRecord> {

    private static final long serialVersionUID = 343699749;

    /** The reference instance of <code>test.qrtz_calendars</code> */
    public static final QrtzCalendars QRTZ_CALENDARS = new QrtzCalendars();

    /** The class holding records for this type */
    @Override
    public Class<QrtzCalendarsRecord> getRecordType() {
        return QrtzCalendarsRecord.class;
    }

    /** The column <code>test.qrtz_calendars.SCHED_NAME</code>. */
    public final TableField<QrtzCalendarsRecord, String> SCHED_NAME =
            createField("SCHED_NAME", org.jooq.impl.SQLDataType.VARCHAR(120).nullable(false), this, "");

    /** The column <code>test.qrtz_calendars.CALENDAR_NAME</code>. */
    public final TableField<QrtzCalendarsRecord, String> CALENDAR_NAME =
            createField("CALENDAR_NAME", org.jooq.impl.SQLDataType.VARCHAR(190).nullable(false), this, "");

    /** The column <code>test.qrtz_calendars.CALENDAR</code>. */
    public final TableField<QrtzCalendarsRecord, byte[]> CALENDAR =
            createField("CALENDAR", org.jooq.impl.SQLDataType.BLOB.nullable(false), this, "");

    /** Create a <code>test.qrtz_calendars</code> table reference */
    public QrtzCalendars() {
        this(DSL.name("qrtz_calendars"), null);
    }

    /** Create an aliased <code>test.qrtz_calendars</code> table reference */
    public QrtzCalendars(String alias) {
        this(DSL.name(alias), QRTZ_CALENDARS);
    }

    /** Create an aliased <code>test.qrtz_calendars</code> table reference */
    public QrtzCalendars(Name alias) {
        this(alias, QRTZ_CALENDARS);
    }

    private QrtzCalendars(Name alias, Table<QrtzCalendarsRecord> aliased) {
        this(alias, aliased, null);
    }

    private QrtzCalendars(Name alias, Table<QrtzCalendarsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /** {@inheritDoc} */
    @Override
    public Schema getSchema() {
        return Test.TEST;
    }

    /** {@inheritDoc} */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.QRTZ_CALENDARS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public UniqueKey<QrtzCalendarsRecord> getPrimaryKey() {
        return Keys.KEY_QRTZ_CALENDARS_PRIMARY;
    }

    /** {@inheritDoc} */
    @Override
    public List<UniqueKey<QrtzCalendarsRecord>> getKeys() {
        return Arrays.<UniqueKey<QrtzCalendarsRecord>>asList(Keys.KEY_QRTZ_CALENDARS_PRIMARY);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzCalendars as(String alias) {
        return new QrtzCalendars(DSL.name(alias), this);
    }

    /** {@inheritDoc} */
    @Override
    public QrtzCalendars as(Name alias) {
        return new QrtzCalendars(alias, this);
    }

    /** Rename this table */
    @Override
    public QrtzCalendars rename(String name) {
        return new QrtzCalendars(DSL.name(name), null);
    }

    /** Rename this table */
    @Override
    public QrtzCalendars rename(Name name) {
        return new QrtzCalendars(name, null);
    }
}
