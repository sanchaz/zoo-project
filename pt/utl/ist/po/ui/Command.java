/**
 * @version $Id: Command.java,v 1.1 2008/10/19 15:27:23 david Exp $
 */
package pt.utl.ist.po.ui;

/**
 * Abstract class <code>Command</code> represents an operation that can be
 * carried out by or over an entity.
 * 
 * @param <Entity>
 *            the entity providing the command's context.
 * @see pt.utl.ist.po.ui.Menu
 * @see pt.utl.ist.po.ui.InvalidOperation
 */
public abstract class Command<Entity> {
	/**
	 * Indicates whether, in a menu, this is the last command.
	 */
	private boolean _last;

	/**
	 * The command label in a menu.
	 */
	private String _title;

	/**
	 * The entity providing the command's context.
	 */
	protected Entity _entity = null;

	/**
	 * @param last
	 *            indicates whether, in a menu, this is the last command.
	 * @param title
	 *            the command label in a menu.
	 */
	public Command(boolean last, String title) {
		_last = last;
		_title = title;
	}

	/**
	 * @param last
	 *            indicates whether, in a menu, this is the last command.
	 * @param title
	 *            the command label in a menu.
	 * @param entity
	 *            the entity providing the command's context.
	 */
	public Command(boolean last, String title, Entity entity) {
		this(last, title);
		_entity = entity;
	}

	/**
	 * @return the command's title.
	 */
	public final String title() {
		return _title;
	}

	/**
	 * Indicates whether, in a menu, this is the last command.
	 * 
	 * @return true if, in a menu, this is the last command.
	 */
	public boolean isLast() {
		return _last;
	}

	/**
	 * Executes the command.
	 * 
	 * @throws InvalidOperation
	 *             if something wrong or unexpected occurs.
	 */
	public abstract void execute() throws InvalidOperation;

}
