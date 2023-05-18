/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 17 мая 2023 г., 12:21:54                    ---
 * ----------------------------------------------------------------
 */
package org.training.core.jalo;

import de.hybris.platform.b2b.jalo.B2BCustomer;
import de.hybris.platform.constants.CoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.order.Order;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.training.core.constants.TrainingCoreConstants;

/**
 * Generated class for type {@link org.training.core.jalo.EcentaNotification EcentaNotification}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedEcentaNotification extends GenericItem
{
	/** Qualifier of the <code>EcentaNotification.id</code> attribute **/
	public static final String ID = "id";
	/** Qualifier of the <code>EcentaNotification.b2bCustomer</code> attribute **/
	public static final String B2BCUSTOMER = "b2bCustomer";
	/** Qualifier of the <code>EcentaNotification.date</code> attribute **/
	public static final String DATE = "date";
	/** Qualifier of the <code>EcentaNotification.type</code> attribute **/
	public static final String TYPE = "type";
	/** Qualifier of the <code>EcentaNotification.message</code> attribute **/
	public static final String MESSAGE = "message";
	/** Qualifier of the <code>EcentaNotification.priority</code> attribute **/
	public static final String PRIORITY = "priority";
	/** Qualifier of the <code>EcentaNotification.read</code> attribute **/
	public static final String READ = "read";
	/** Qualifier of the <code>EcentaNotification.deleted</code> attribute **/
	public static final String DELETED = "deleted";
	/** Qualifier of the <code>EcentaNotification.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>EcentaNotification.orders</code> attribute **/
	public static final String ORDERS = "orders";
	/**
	* {@link OneToManyHandler} for handling 1:n ORDERS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<Order> ORDERSHANDLER = new OneToManyHandler<Order>(
	CoreConstants.TC.ORDER,
	true,
	"notification",
	null,
	false,
	true,
	CollectionType.SET
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ID, AttributeMode.INITIAL);
		tmp.put(B2BCUSTOMER, AttributeMode.INITIAL);
		tmp.put(DATE, AttributeMode.INITIAL);
		tmp.put(TYPE, AttributeMode.INITIAL);
		tmp.put(MESSAGE, AttributeMode.INITIAL);
		tmp.put(PRIORITY, AttributeMode.INITIAL);
		tmp.put(READ, AttributeMode.INITIAL);
		tmp.put(DELETED, AttributeMode.INITIAL);
		tmp.put(TITLE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.b2bCustomer</code> attribute.
	 * @return the b2bCustomer - ID of B2B customer to whom notification is sent
	 */
	public B2BCustomer getB2bCustomer(final SessionContext ctx)
	{
		return (B2BCustomer)getProperty( ctx, B2BCUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.b2bCustomer</code> attribute.
	 * @return the b2bCustomer - ID of B2B customer to whom notification is sent
	 */
	public B2BCustomer getB2bCustomer()
	{
		return getB2bCustomer( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.b2bCustomer</code> attribute. 
	 * @param value the b2bCustomer - ID of B2B customer to whom notification is sent
	 */
	public void setB2bCustomer(final SessionContext ctx, final B2BCustomer value)
	{
		setProperty(ctx, B2BCUSTOMER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.b2bCustomer</code> attribute. 
	 * @param value the b2bCustomer - ID of B2B customer to whom notification is sent
	 */
	public void setB2bCustomer(final B2BCustomer value)
	{
		setB2bCustomer( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.date</code> attribute.
	 * @return the date - Editable date of notification
	 */
	public Date getDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, DATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.date</code> attribute.
	 * @return the date - Editable date of notification
	 */
	public Date getDate()
	{
		return getDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.date</code> attribute. 
	 * @param value the date - Editable date of notification
	 */
	public void setDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, DATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.date</code> attribute. 
	 * @param value the date - Editable date of notification
	 */
	public void setDate(final Date value)
	{
		setDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.deleted</code> attribute.
	 * @return the deleted - Old notification deletion mark
	 */
	public Boolean isDeleted(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, DELETED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.deleted</code> attribute.
	 * @return the deleted - Old notification deletion mark
	 */
	public Boolean isDeleted()
	{
		return isDeleted( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.deleted</code> attribute. 
	 * @return the deleted - Old notification deletion mark
	 */
	public boolean isDeletedAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isDeleted( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.deleted</code> attribute. 
	 * @return the deleted - Old notification deletion mark
	 */
	public boolean isDeletedAsPrimitive()
	{
		return isDeletedAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.deleted</code> attribute. 
	 * @param value the deleted - Old notification deletion mark
	 */
	public void setDeleted(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, DELETED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.deleted</code> attribute. 
	 * @param value the deleted - Old notification deletion mark
	 */
	public void setDeleted(final Boolean value)
	{
		setDeleted( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.deleted</code> attribute. 
	 * @param value the deleted - Old notification deletion mark
	 */
	public void setDeleted(final SessionContext ctx, final boolean value)
	{
		setDeleted( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.deleted</code> attribute. 
	 * @param value the deleted - Old notification deletion mark
	 */
	public void setDeleted(final boolean value)
	{
		setDeleted( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.id</code> attribute.
	 * @return the id - An ID used to uniquely identify this entity
	 */
	public String getId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.id</code> attribute.
	 * @return the id - An ID used to uniquely identify this entity
	 */
	public String getId()
	{
		return getId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.id</code> attribute. 
	 * @param value the id - An ID used to uniquely identify this entity
	 */
	protected void setId(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+ID+"' is not changeable", 0 );
		}
		setProperty(ctx, ID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.id</code> attribute. 
	 * @param value the id - An ID used to uniquely identify this entity
	 */
	protected void setId(final String value)
	{
		setId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.message</code> attribute.
	 * @return the message - Message of notification
	 */
	public String getMessage(final SessionContext ctx)
	{
		return (String)getProperty( ctx, MESSAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.message</code> attribute.
	 * @return the message - Message of notification
	 */
	public String getMessage()
	{
		return getMessage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.message</code> attribute. 
	 * @param value the message - Message of notification
	 */
	public void setMessage(final SessionContext ctx, final String value)
	{
		setProperty(ctx, MESSAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.message</code> attribute. 
	 * @param value the message - Message of notification
	 */
	public void setMessage(final String value)
	{
		setMessage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.orders</code> attribute.
	 * @return the orders
	 */
	public Set<Order> getOrders(final SessionContext ctx)
	{
		return (Set<Order>)ORDERSHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.orders</code> attribute.
	 * @return the orders
	 */
	public Set<Order> getOrders()
	{
		return getOrders( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.orders</code> attribute. 
	 * @param value the orders
	 */
	public void setOrders(final SessionContext ctx, final Set<Order> value)
	{
		ORDERSHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.orders</code> attribute. 
	 * @param value the orders
	 */
	public void setOrders(final Set<Order> value)
	{
		setOrders( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to orders. 
	 * @param value the item to add to orders
	 */
	public void addToOrders(final SessionContext ctx, final Order value)
	{
		ORDERSHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to orders. 
	 * @param value the item to add to orders
	 */
	public void addToOrders(final Order value)
	{
		addToOrders( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from orders. 
	 * @param value the item to remove from orders
	 */
	public void removeFromOrders(final SessionContext ctx, final Order value)
	{
		ORDERSHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from orders. 
	 * @param value the item to remove from orders
	 */
	public void removeFromOrders(final Order value)
	{
		removeFromOrders( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.priority</code> attribute.
	 * @return the priority - Priority of notification
	 */
	public EnumerationValue getPriority(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, PRIORITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.priority</code> attribute.
	 * @return the priority - Priority of notification
	 */
	public EnumerationValue getPriority()
	{
		return getPriority( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.priority</code> attribute. 
	 * @param value the priority - Priority of notification
	 */
	public void setPriority(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, PRIORITY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.priority</code> attribute. 
	 * @param value the priority - Priority of notification
	 */
	public void setPriority(final EnumerationValue value)
	{
		setPriority( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.read</code> attribute.
	 * @return the read - Is notification read
	 */
	public Boolean isRead(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, READ);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.read</code> attribute.
	 * @return the read - Is notification read
	 */
	public Boolean isRead()
	{
		return isRead( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.read</code> attribute. 
	 * @return the read - Is notification read
	 */
	public boolean isReadAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isRead( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.read</code> attribute. 
	 * @return the read - Is notification read
	 */
	public boolean isReadAsPrimitive()
	{
		return isReadAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.read</code> attribute. 
	 * @param value the read - Is notification read
	 */
	public void setRead(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, READ,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.read</code> attribute. 
	 * @param value the read - Is notification read
	 */
	public void setRead(final Boolean value)
	{
		setRead( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.read</code> attribute. 
	 * @param value the read - Is notification read
	 */
	public void setRead(final SessionContext ctx, final boolean value)
	{
		setRead( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.read</code> attribute. 
	 * @param value the read - Is notification read
	 */
	public void setRead(final boolean value)
	{
		setRead( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.title</code> attribute.
	 * @return the title - Title of notification
	 */
	public String getTitle(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.title</code> attribute.
	 * @return the title - Title of notification
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.title</code> attribute. 
	 * @param value the title - Title of notification
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.title</code> attribute. 
	 * @param value the title - Title of notification
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.type</code> attribute.
	 * @return the type - Type of notification
	 */
	public EnumerationValue getType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EcentaNotification.type</code> attribute.
	 * @return the type - Type of notification
	 */
	public EnumerationValue getType()
	{
		return getType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.type</code> attribute. 
	 * @param value the type - Type of notification
	 */
	public void setType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, TYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EcentaNotification.type</code> attribute. 
	 * @param value the type - Type of notification
	 */
	public void setType(final EnumerationValue value)
	{
		setType( getSession().getSessionContext(), value );
	}
	
}
