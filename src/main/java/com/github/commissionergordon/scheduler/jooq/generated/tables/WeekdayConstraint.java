/**
 * This class is generated by jOOQ
 */
package com.github.commissionergordon.scheduler.jooq.generated.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.2"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WeekdayConstraint extends org.jooq.impl.TableImpl<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord> {

	private static final long serialVersionUID = 2027598451;

	/**
	 * The reference instance of <code>PUBLIC.WEEKDAY_CONSTRAINT</code>
	 */
	public static final com.github.commissionergordon.scheduler.jooq.generated.tables.WeekdayConstraint WEEKDAY_CONSTRAINT = new com.github.commissionergordon.scheduler.jooq.generated.tables.WeekdayConstraint();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord> getRecordType() {
		return com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord.class;
	}

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.WEEKDAY_CONSTRAINT_ID</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Integer> WEEKDAY_CONSTRAINT_ID = createField("WEEKDAY_CONSTRAINT_ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.CONSTRAINT_ID</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Integer> CONSTRAINT_ID = createField("CONSTRAINT_ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.CAN</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Boolean> CAN = createField("CAN", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.SUNDAY</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Boolean> SUNDAY = createField("SUNDAY", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.MONDAY</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Boolean> MONDAY = createField("MONDAY", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.TUESDAY</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Boolean> TUESDAY = createField("TUESDAY", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.WEDNESDAY</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Boolean> WEDNESDAY = createField("WEDNESDAY", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.THURSDAY</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Boolean> THURSDAY = createField("THURSDAY", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.FRIDAY</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Boolean> FRIDAY = createField("FRIDAY", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.WEEKDAY_CONSTRAINT.SATURDAY</code>.
	 */
	public final org.jooq.TableField<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Boolean> SATURDAY = createField("SATURDAY", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>PUBLIC.WEEKDAY_CONSTRAINT</code> table reference
	 */
	public WeekdayConstraint() {
		this("WEEKDAY_CONSTRAINT", null);
	}

	/**
	 * Create an aliased <code>PUBLIC.WEEKDAY_CONSTRAINT</code> table reference
	 */
	public WeekdayConstraint(java.lang.String alias) {
		this(alias, com.github.commissionergordon.scheduler.jooq.generated.tables.WeekdayConstraint.WEEKDAY_CONSTRAINT);
	}

	private WeekdayConstraint(java.lang.String alias, org.jooq.Table<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord> aliased) {
		this(alias, aliased, null);
	}

	private WeekdayConstraint(java.lang.String alias, org.jooq.Table<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.github.commissionergordon.scheduler.jooq.generated.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord, java.lang.Integer> getIdentity() {
		return com.github.commissionergordon.scheduler.jooq.generated.Keys.IDENTITY_WEEKDAY_CONSTRAINT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord> getPrimaryKey() {
		return com.github.commissionergordon.scheduler.jooq.generated.Keys.CONSTRAINT_3;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.github.commissionergordon.scheduler.jooq.generated.tables.records.WeekdayConstraintRecord>>asList(com.github.commissionergordon.scheduler.jooq.generated.Keys.CONSTRAINT_3);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.github.commissionergordon.scheduler.jooq.generated.tables.WeekdayConstraint as(java.lang.String alias) {
		return new com.github.commissionergordon.scheduler.jooq.generated.tables.WeekdayConstraint(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.github.commissionergordon.scheduler.jooq.generated.tables.WeekdayConstraint rename(java.lang.String name) {
		return new com.github.commissionergordon.scheduler.jooq.generated.tables.WeekdayConstraint(name, null);
	}
}