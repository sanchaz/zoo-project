/**
 * @version $Id: Menu.java,v 1.1 2008/10/19 15:27:23 david Exp $
 */
package pt.utl.ist.po.ui;

import java.io.EOFException;
import java.io.IOException;
import pt.utl.ist.po.RuntimeEOFException;
import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
 * Class Menu manages a set of commands.
 * 
 * @see pt.utl.ist.po.ui.Command
 * @see pt.utl.ist.po.ui.UserInteraction
 */
@SuppressWarnings("nls")
public class Menu {

	/**
	 * Messages used by class Menu.
	 */
	private static final class Messages {

		/**
		 * Prompt for menu option.
		 * 
		 * @return prompt text.
		 */
		static final String selectAnOption() {
			return "Escolha uma opção: ";
		}

		/**
		 * Massage for communicating an invalid option.
		 * 
		 * @return message text.
		 */
		static final String invalidOption() {
			return "Opção inválida!";
		}

		/**
		 * Exit option for all menus.
		 * 
		 * @return message text.
		 */
		static final String exit() {
			return "0 - Sair";
		}

	}

	/**
	 * Menu title.
	 */
	private String _title;

	/**
	 * Commands available from the menu.
	 */
	private Command<?> _commands[];

	/**
	 * Constructor.
	 * 
	 * @param title
	 *            menu title.
	 * 
	 * @param commands
	 *            list of commands managed by the menu.
	 */
	public Menu(String title, Command<?> commands[]) {
		_title = title;
		_commands = commands;
	}

	/**
	 * Main function: the menu interacts with the user and executes the
	 * appropriate commands.
	 */
	public void open() {
		int option = 0, i;

		while (true) {
			IO.println(_title);
			for (i = 0; i < _commands.length; i++)
				IO.println((i + 1) + " - " + _commands[i].title()); //$NON-NLS-1$
			IO.println(Messages.exit());

			try {
				option = IO.readInteger(Messages.selectAnOption());
				if (option == 0)
					return;

				if (option < 0 || option > i) {
					IO.println(Messages.invalidOption());
				} else {
					_commands[option - 1].execute();
					if (_commands[option - 1].isLast())
						return;
				}
			} catch (InvalidOperation oi) {
				IO.println(_commands[option - 1].title() + ": " + oi); //$NON-NLS-1$
			} catch (EOFException eof) {
				IO.println(pt.utl.ist.po.ui.Messages.errorEOF(eof));
				return;
			} catch (IOException ioe) {
				IO.println(pt.utl.ist.po.ui.Messages.errorIO(ioe));
			} catch (NumberFormatException nbf) {
				IO.println(pt.utl.ist.po.ui.Messages.errorInvalidNumber(nbf));
			} catch (RuntimeEOFException e) {
				// Não devia ser preciso mas há alunos que apanham
				// IOException e não fazem nada.
				IO.println(pt.utl.ist.po.ui.Messages.errorREOF(e));
				return;
			}
		}
	}

}
