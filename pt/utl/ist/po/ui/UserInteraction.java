/**
 * @version $Id: UserInteraction.java,v 1.1 2008/10/19 15:27:23 david Exp $
 */
package pt.utl.ist.po.ui;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import pt.utl.ist.po.CompositePrintStream;
import pt.utl.ist.po.RuntimeEOFException;

/**
 * User interaction (either through the keyboard or files).
 */
public class UserInteraction {

	/**
	 * 
	 */
	@SuppressWarnings("nls")
	static final class Messages {

		/**
		 * Error message for file-not-found errors (input).
		 * 
		 * @param fnfe
		 *            an exception corresponding to a file-not-found problem.
		 * @return error message.
		 */
		static final String inputError(FileNotFoundException fnfe) {
			return "Erro a colocar a entrada de dados: " + fnfe;
		}

		/**
		 * Error message for file-not-found errors (output).
		 * 
		 * @param fnfe
		 *            an exception corresponding to a file-not-found problem.
		 * @return error message.
		 */
		static final String outputError(FileNotFoundException fnfe) {
			return "Erro a colocar a saída de dados: " + fnfe;
		}

		/**
		 * Error message for file-not-found errors (log).
		 * 
		 * @param fnfe
		 *            an exception corresponding to a file-not-found problem.
		 * @return error message.
		 */
		static final String logError(FileNotFoundException fnfe) {
			return "Erro a especificar o ficheiro de log: " + fnfe;
		}

		/**
		 * Error message for IO errors (closing input).
		 * 
		 * @param ioe
		 *            an IO exception.
		 * @return error message.
		 */
		static final String errorClosingInput(IOException ioe) {
			return "Erro a fechar entrada de dados: " + ioe;
		}

		/**
		 * Error message for number format errors.
		 * 
		 * @param nfe
		 *            a <code>NumberFormatException</code>.
		 * @return error message.
		 */
		static final String invalidNumber(NumberFormatException nfe) {
			return "Número inválido!";
		}

		/**
		 * Error message for EOF errors.
		 * 
		 * @return error message.
		 */
		static final String endOfInput() {
			return "Fim do fluxo de dados de entrada";
		}

		/**
		 * @return input property name.
		 */
		static final String inputChannel() {
			return "in";
		}

		/**
		 * @return output property name.
		 */
		static final String outputChannel() {
			return "out";
		}

		/**
		 * Use multiple channels?
		 * 
		 * @return both channels property name.
		 */
		static final String bothChannels() {
			return "both";
		}

		/**
		 * @return log channel property name.
		 */
		static final String logChannel() {
			return "log";
		}

		/**
		 * Should input be copied to the output?
		 * 
		 * @return property name.
		 */
		static final String writeInput() {
			return "writeInput";
		}

	}

	/** Single instance of this class. */
	public static/* final */UserInteraction IO = new UserInteraction();

	/**
	 * Input channel.
	 */
	private BufferedReader _in;

	/**
	 * Output channel.
	 */
	private PrintStream _out;

	/**
	 * Log channel.
	 */
	private PrintStream _log;

	/**
	 * Copy input to output?
	 */
	private boolean _writeInput;

	/**
	 * Single constructor (private).
	 */
	private UserInteraction() {
		String nome = System.getProperty(Messages.inputChannel());

		if (nome != null) {
			try {
				_in = new BufferedReader(new FileReader(nome));
			} catch (FileNotFoundException fn) {
				println(Messages.inputError(fn));
				nome = null; // uses the default value
			}
		}

		if (nome == null)
			_in = new BufferedReader(new InputStreamReader(System.in));

		nome = System.getProperty(Messages.outputChannel());

		if (nome != null) {
			try {
				PrintStream pr = new PrintStream(new FileOutputStream(nome));
				if (Boolean.getBoolean(Messages.bothChannels())) {
					CompositePrintStream out = new CompositePrintStream();
					out.add(pr);
					out.add(System.out);
					_out = out;
				} else
					_out = pr;
			} catch (FileNotFoundException fn) {
				println(Messages.outputError(fn));
				nome = null; // uses the default value
			}
		}

		if (nome == null)
			_out = System.out;

		nome = System.getProperty(Messages.logChannel());
		if (nome != null) {
			try {
				_log = new PrintStream(new FileOutputStream(nome));
			} catch (FileNotFoundException fn) {
				println(Messages.logError(fn));
				nome = null; // uses the default value
			}
		}

		if (nome == null)
			_log = null;

		_writeInput = Boolean.getBoolean(Messages.writeInput());
	}

	/**
	 * Close all I/O channels.
	 */
	public void closeDown() {
		if (System.out != _out)
			_out.close();
		try {
			String nome = System.getProperty(Messages.inputChannel());
			if (nome != null)
				_in.close();
		} catch (IOException ioe) {
			println(Messages.errorClosingInput(ioe));
		}

		if (_log != null)
			_log.close();
	}

	/**
	 * Read an integer number from the input.
	 * 
	 * @param prompt
	 *            a prompt (may be null)
	 * @return the number read from the input.
	 * @throws IOException
	 *             in case of read errors
	 */
	public final int readInteger(String prompt) throws IOException {
		while (true) {
			try {
				return Integer.parseInt(readString(prompt));
			} catch (NumberFormatException e) {
				println(Messages.invalidNumber(e));
			}
		}
	}

	/**
	 * Read a floating point number from the input.
	 * 
	 * @param prompt
	 *            a prompt (may be null)
	 * @return the number read from the input.
	 * @throws IOException
	 *             in case of read errors
	 */
	public final float readFloat(String prompt) throws IOException {
		while (true) {
			try {
				return Float.parseFloat(readString(prompt));
			} catch (NumberFormatException e) {
				println(Messages.invalidNumber(e));
			}
		}
	}

	/**
	 * Read a boolean from the input. 's' corresponds to true and 'n' to false.
	 * 
	 * @param prompt
	 *            a prompt (may be null)
	 * @return the boolean read from the input.
	 * @throws IOException
	 *             in case of read errors
	 * 
	 */
	public final boolean readBoolean(String prompt) throws IOException {
		while (true) {
			String res = readString(prompt);
			if (res.length() == 1
					&& (res.charAt(0) == 's' || res.charAt(0) == 'n'))
				return res.charAt(0) == 's';
		}
	}

	/**
	 * Read a string.
	 * 
	 * @param prompt
	 *            a prompt (may be null)
	 * @return the string read from the input.
	 * @throws IOException
	 *             in case of read errors
	 * @throws EOFException
	 *             in case of end of file errors
	 */
	public final String readString(String prompt) throws IOException {
		if (prompt != null)
			_out.print(prompt);
		String str = _in.readLine();
		if (str == null) {
			// infelizmente tem que ser esta excepcao pq ha
			// alunos que a apanham e nao fazem nada
			throw new RuntimeEOFException(Messages.endOfInput());
		}

		if (_log != null)
			_log.println(str);

		if (_writeInput)
			_out.println(str);

		return str;
	}

	/**
	 * Write a string.
	 * 
	 * @param text
	 *            string to write.
	 */
	public final void println(String text) {
		_out.println(text);
	}

}