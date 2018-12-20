package com.br.loja.util;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	public static SimpleDateFormat simpleDateFormatHHMMSS = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat simpleOnlyDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat simpleOnlyMMDD = new SimpleDateFormat("dd/MM");
	public static NumberFormat nf = NumberFormat.getInstance();
	public static final DecimalFormat df = new DecimalFormat("#,##0");

	protected static Logger logger = LoggerFactory.getLogger(StringUtil.class);

	public StringUtil() {

	}

	public static String limit(String valor, int limit) {
		if (valor != null) {

			if (valor.length() <= limit) {
				return valor;
			} else {
				return valor.substring(0, limit - 1);
			}

		}

		return null;
	}

	/**
	 * Verifica se a String � igual utilizando "equalsIgnoreCase" e "trim"
	 * 
	 * @param s
	 * @param s2
	 * @return
	 */
	public static boolean compare(String s, String s2) {
		return s.trim().equalsIgnoreCase(s2.trim());
	}

	public static boolean isFolderID(String str) {
		if (StringUtil.isVoid(str)) {
			return false;
		}
		boolean result = str != null && !str.trim().equalsIgnoreCase("") && !str.equalsIgnoreCase("null");

		return result && str.toUpperCase().lastIndexOf("P") > -1;
	}

	public static long normalizeIdPasta(String str) {
		return new Long(str.replace("P", "")).longValue();
	}

	public static int getPorcento(int atual, int total) {
		nf.setMaximumFractionDigits(0);
		return Integer.parseInt(nf.format(((double) atual / (double) total) * 100));
	}

	/**
	 * Remove todo tipo de acentuacoes
	 * 
	 * @param string
	 * @return
	 */
	public static String removeAcentos(String string) {
		if (string == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder(string);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�'
					|| sb.charAt(i) == '�') {
				sb.setCharAt(i, 'a');
			} else if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�') {
				sb.setCharAt(i, 'e');
			} else if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�') {
				sb.setCharAt(i, 'i');
			} else if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�'
					|| sb.charAt(i) == '�') {
				sb.setCharAt(i, 'o');
			} else if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�') {
				sb.setCharAt(i, 'u');
			} else if (sb.charAt(i) == '�') {
				sb.setCharAt(i, 'c');
			} else if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�'
					|| sb.charAt(i) == '�') {
				sb.setCharAt(i, 'A');
			} else if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�') {
				sb.setCharAt(i, 'E');
			} else if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�') {
				sb.setCharAt(i, 'I');
			} else if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�'
					|| sb.charAt(i) == '�') {
				sb.setCharAt(i, 'O');
			} else if (sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�' || sb.charAt(i) == '�') {
				sb.setCharAt(i, 'U');
			} else if (sb.charAt(i) == '�') {
				sb.setCharAt(i, 'C');
			}
		}

		return sb.toString();
	}

	private static final char[] FIRST_CHAR = (" !'#$%&'()*+\\-./0123456789:;<->?@ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ E,f'.++^%S<O Z  ''''.-"
			+ "-~Ts>o ZY !C#$Y|$'(a<--(_o+23'u .,1o>113?AAAAAAACEEEEIIIIDNOO"
			+ "OOOXOUUUUyTsaaaaaaaceeeeiiiidnooooo/ouuuuyty").toCharArray();

	/** Para a normaliza��o dos caracteres de 32 a 255, segundo caracter */
	private static final char[] SECOND_CHAR = ("  '         ,                                               "
			+ "\\                                   $  r'. + o  E      ''  "
			+ "  M  e     #  =  'C.<  R .-..     ..>424     E E            "
			+ "   E E     hs    e e         h     e e     h ").toCharArray();

	public static String normalize(String str) {

		char[] chars = str.toCharArray();
		StringBuilder ret = new StringBuilder(chars.length * 2);
		for (int i = 0; i < chars.length; ++i) {
			char aChar = chars[i];

			// excecao com a virgula nao acha o indice no array de char
			if (chars[i] == ',') {
				ret.append(',');
				continue;
			}
			if (aChar == ' ' || aChar == '\t') {
				ret.append(' '); // convertido para espa�o
			} else if (aChar == '/' || aChar == '\\') {
				ret.append('_'); // convertido para espa�o
			} else if (aChar > ' ' && aChar < 256) {
				if (FIRST_CHAR[aChar - ' '] != ' ') {
					ret.append(FIRST_CHAR[aChar - ' ']); // 1 caracter
				}
				if (SECOND_CHAR[aChar - ' '] != ' ') {
					ret.append(SECOND_CHAR[aChar - ' ']); // 2 caracteres
				}
			}
		}

		return ret.toString();
	}

	public static void main(String[] args) {
		String text = "223.877.508-05.5";

		String text2 = normalize(text);
		System.out.println(text2);

		text2 = removeCaracteresInvalidos(text);
		System.out.println(text2);

	}

	public static String normalizeApostrofe(String s) {
		if (isVoid(s)) {
			return "";
		}
		return s.replaceAll("'", "");
	}

	public static String normalizaTexto(final String str) {
		String strSemAcentos = Normalizer.normalize(str, Normalizer.Form.NFD);
		strSemAcentos = strSemAcentos.replaceAll("[^\\p{ASCII}]", "");
		return strSemAcentos;
	}

	public static String normalizeToCsv(String s) {

		if (isVoid(s)) {
			return " ";
		}
		String to = new String(s);

		to = to.replaceAll("\"", "\"\"");
		to = "\"" + to + "\"";

		to = removeAcentos(to);
		// to = replaceByConf(to);
		to = removeQuebraLinha(to);

		return to.toUpperCase().trim();
	}

	public static String removeQuebraLinha(String s) {
		s = s.replaceAll("\r", "");
		return s.replaceAll("\n", "");
	}

	/**
	 * Substitui as letras que possui acentos para sem acento.
	 * 
	 * @param valor
	 * @return
	 */
	public static String replaceAcentos(String valor) {
		valor = valor.replaceAll("�", "a");
		valor = valor.replaceAll("�", "a");
		valor = valor.replaceAll("�", "a");
		valor = valor.replaceAll("�", "a");
		valor = valor.replaceAll("�", "e");
		valor = valor.replaceAll("�", "e");
		valor = valor.replaceAll("�", "e");
		valor = valor.replaceAll("�", "n");
		valor = valor.replaceAll("�", "i");
		valor = valor.replaceAll("�", "o");
		valor = valor.replaceAll("�", "o");
		valor = valor.replaceAll("�", "o");
		valor = valor.replaceAll("�", "o");
		valor = valor.replaceAll("�", "u");
		valor = valor.replaceAll("�", "u");
		valor = valor.replaceAll("�", "u");
		valor = valor.replaceAll("�", "c");

		valor = valor.replaceAll("�", "A");
		valor = valor.replaceAll("�", "A");
		valor = valor.replaceAll("�", "A");
		valor = valor.replaceAll("�", "A");
		valor = valor.replaceAll("�", "E");
		valor = valor.replaceAll("�", "E");
		valor = valor.replaceAll("�", "E");
		valor = valor.replaceAll("�", "I");
		valor = valor.replaceAll("�", "O");
		valor = valor.replaceAll("�", "O");
		valor = valor.replaceAll("�", "O");
		valor = valor.replaceAll("�", "O");
		valor = valor.replaceAll("�", "U");
		valor = valor.replaceAll("�", "U");
		valor = valor.replaceAll("�", "U");
		valor = valor.replaceAll("�", "C");
		valor = valor.replaceAll("�", "N");
		valor = valor.replaceAll(" ", "_");

		valor = cleanString(valor);

		return valor;
	}

	public static String cleanString(String toRep) {

		if (toRep == null || toRep.length() <= 0) {
			return toRep;
		}

		String temp = "";

		for (int i = 0; i < toRep.length(); i++) {
			Character c = new Character(toRep.charAt(i));
			if (!Character.isHighSurrogate(c)) {
				temp += "_";
			} else {
				temp += c;
			}

		}

		return temp;

	}

	/**
	 * Metodo responsavel em p�r pontos de retic�ncia somente em textos sem
	 * espa�o, n�o permitindo exprimir o texto completamente.
	 * 
	 * @param txt
	 *            (texto a ser formatado)
	 * @param limitCarac
	 *            (quantidade de caracteres a serem exibidos)
	 * @return
	 */
	public static String formatReticencia(String txt, int limitCarac) {
		if (txt == null)
			return null;

		if (txt.length() > limitCarac) {
			if (txt.indexOf(' ') < 0) { // verifica se nao contem espa�os
				txt = txt.substring(0, (limitCarac - 3)).concat("...");
			}
		}
		return txt;
	}

	/**
	 * Metodo responsavel em idenficar em destaque a palavra especifica em um
	 * texto na palavra encontrada.
	 * 
	 * @param texto
	 *            ( texto a ser modificado por highlith)
	 * @param palavra
	 *            ( palavra a ser encontrada no <b>texto</b>)
	 * @param formatIni
	 *            ( formato da <b>palavra</b> encontrada ex: <span ....>
	 * @param formatEnd
	 *            ( formato html fechamento da tag do formatIni ex: </span...>
	 * @return ( texto formatado com highligh
	 */
	public static String highlight(String texto, String palavra, String formatIni, String formatEnd) {
		String textoModifier = texto.toUpperCase().trim();
		String[] palavraUp = palavra.toUpperCase().trim().split(" ");
		for (int i = 0; i < palavraUp.length; i++) {
			textoModifier = textoModifier.replaceAll(palavraUp[i], formatIni + palavraUp[i] + formatEnd);
		}

		return textoModifier;
	}

	public static boolean isVoid(String s) {

		return (s == null || s.trim().length() <= 0 || "null".equalsIgnoreCase(s.trim()));

	}

	public static boolean isVoid(Object s) {

		return (s == null || s.toString() == null || s.toString().trim().length() <= 0
				|| "null".equalsIgnoreCase(s.toString().trim()));

	}

	public static boolean isVoid(Object[] s) {

		return (s == null || s.length <= 0);

	}

	public static boolean isVoid(Collection s) {

		return (s == null || s.isEmpty());

	}

	/**
	 * 
	 * @param time
	 * @return
	 */
	public static String getFormatedDate(long time) {

		try {
			return simpleDateFormat.format(new Date(time));
		} catch (Exception e) {
			return "*Data inv�lida*";
		}

	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getFormatedDateObject(Object date) {
		Date odate = null;

		if (date == null) {
			return null;
		}

		if (date instanceof java.util.Date) {
			odate = (Date) date;
		} else {
			return null;
		}

		try {
			return simpleOnlyDateFormat.format(odate);
		} catch (Exception e) {
			return "*Data inv�lida*";
		}

	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getFormatedDDMMObject(Object date) {
		Date odate = null;

		if (date == null) {
			return null;
		}

		if (date instanceof java.util.Date) {
			odate = (Date) date;
		} else {
			return null;
		}

		try {
			return simpleOnlyMMDD.format(odate);
		} catch (Exception e) {
			return "*Data inv�lida*";
		}

	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getFormatedDate(Date date) {

		try {
			return simpleDateFormat.format(date);
		} catch (Exception e) {
			return "*Data inv�lida*";
		}

	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getFormatedDateHHMMSS(Date date) {
		try {
			return simpleDateFormatHHMMSS.format(date);
		} catch (Exception e) {
			return "*Data inv�lida*";
		}
	}

	/**
	 * 
	 * @param date
	 * @param onlyDate
	 * @return
	 */
	public static String getFormatedDate(Date date, boolean onlyDate) {

		try {
			if (onlyDate) {
				return simpleOnlyDateFormat.format(date);
			} else {

				return simpleDateFormat.format(date);
			}
		} catch (Exception e) {
			return "*Data inv�lida*";
		}

	}

	public static Date parseDate(String date) {

		try {
			return simpleDateFormat.parse(date);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public static Date parseDate(String date, String format) {

		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	public static String removeUltimoCaracter(String s) {
		if (s.length() > 0) {
			return s.substring(0, s.length() - 1);
		}
		return "";
	}

	public static String removeUltimaPalavra(String s) {
		if (isVoid(s)) {
			return "";
		}
		s = s.trim();
		while (!existeEspacoBrancoNoFim(s)) {
			s = removeUltimoCaracter(s);
		}
		return s;
	}

	public static boolean existeEspacoBrancoNoFim(String s) {
		return s.substring(s.length() - 1, s.length()).equals(" ");
	}

	public static String getResumoTexto(String text, String wordsSearch, int size) {
		if (text == null || wordsSearch == null || size <= 0) {
			return "";
		}

		int posFirst = getFirstOcurrenceString(text, wordsSearch);
		int textSize = text.length();

		String textReturn = "";

		if (textSize < size) {
			return text;
		}

		if ((posFirst + size) > textSize) {
			int diff = (posFirst + size) - textSize;
			if (posFirst - diff < 0) {
				textReturn = text;
			} else {
				textReturn = text.substring(posFirst - diff, textSize);
			}
		} else {
			textReturn = text.substring(posFirst, posFirst + size);
		}

		return textReturn;
	}

	public static String[] splitQuery(String wordSearch) {
		String strSplit[] = wordSearch.split(" AND ");
		if (strSplit.length <= 0) {
			strSplit = wordSearch.split(" OR ");
		}
		return strSplit;
	}

	/**
	 * 
	 * @param text
	 * @param wordSearch
	 * @return
	 */
	public static int getFirstOcurrenceString(String text, String wordSearch) {
		if (text == null || wordSearch == null) {
			return 0;
		}
		String strSplit[] = splitQuery(wordSearch);
		int posFirst = 0;
		for (int i = 0; i < strSplit.length; i++) {
			int pos = text.toUpperCase().indexOf(strSplit[i].toUpperCase());
			if (pos > -1 && (posFirst == 0 || pos < posFirst)) {
				posFirst = pos;
			}
		}
		return posFirst;
	}

	/**
	 * 
	 * @param s
	 * @param formato
	 * @return
	 */
	public static Date convertStringToDate(String s, String formato) {
		Date retorno = null;

		if (null != s) {
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			try {
				retorno = sdf.parse(s);
			} catch (ParseException e) {
				logger.error(e.getMessage());
			}
		}

		return retorno;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isBlankOrNull(String value) {
		boolean retorno = false;

		if (value == null) {
			return true;
		}

		if ("".equals(value)) {
			return true;
		}

		return retorno;
	}

	public static boolean isBlankZeroOrNull(String value) {
		boolean retorno = false;

		if (value == null) {
			return true;
		}

		if ("".equals(value)) {
			return true;
		}

		if ("".equals(value.trim())) {
			return true;
		}

		if ("0".equals(value)) {
			return true;
		}

		return retorno;
	}

	public static boolean isBlankOrNull(Integer value) {
		boolean retorno = false;

		if (value == null) {
			return true;
		}

		if ("".equals(value)) {
			return true;
		}

		if (0 == (value.intValue())) {
			return true;
		}

		return retorno;
	}

	public static boolean isBlankOrNull(Long value) {
		boolean retorno = false;

		if (value == null) {
			return true;
		}

		if ("".equals(value)) {
			return true;
		}

		if (0 == (value.intValue())) {
			return true;
		}

		return retorno;
	}

	/**
	 * 
	 * @param o
	 * @return
	 */
	public static Long getLong(Object o) {
		if (o == null) {
			return new Long(0);
		}

		if (o instanceof Integer) {
			return new Long((Integer) o);
		}

		if (o instanceof String) {
			return Long.parseLong((String) o);
		}
		
		if (o instanceof BigInteger) {
			try {
				return ((BigInteger) o).longValue();
			} catch (Exception e) {
				return 0l;
			}
		}

		if (o instanceof BigDecimal) {
			try {
				return ((BigDecimal) o).longValue();
			} catch (Exception e) {
				return 0l;
			}
		}

		return null;
	}

	/**
	 * 
	 * @param o
	 * @return
	 */
	public static BigInteger getBigInteger(Object o) {
		if (o == null) {
			return BigInteger.ZERO;
		}

		if (o instanceof BigInteger) {
			try {
				return ((BigInteger) o);
			} catch (Exception e) {
				return BigInteger.ZERO;
			}
		}
		return BigInteger.ZERO;
	}

	/**
	 * 
	 * @param o
	 * @return
	 */
	public static Integer getInteger(Object o) {
		if (o == null) {
			return new Integer(0);
		}

		if (o instanceof Integer) {
			return ((Integer) o);
		}

		if (o instanceof Long) {
			return ((Long) o).intValue();
		}

		if (o instanceof String) {
			try {
				return Integer.parseInt((String) o);
			} catch (Exception e) {
				return 0;
			}
		}
		
		if (o instanceof Boolean) {
			try {
				return ((Boolean) o) ? 1 : 0;
			} catch (Exception e) {
				return 0;
			}
		}

		if (o instanceof BigInteger) {
			try {
				return ((BigInteger) o).intValue();
			} catch (Exception e) {
				return 0;
			}
		}

		if (o instanceof BigDecimal) {
			try {
				return ((BigDecimal) o).intValue();
			} catch (Exception e) {
				return 0;
			}
		}

		return null;
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	public static Date getDate(Object object) {

		if (object == null) {
			return null;
		}

		if (object instanceof Timestamp) {
			Timestamp stamp = (Timestamp) (object);
			Date date = new Date(stamp.getTime());
			return date;
		}

		if (object instanceof Date) {
			Date date = (Date) (object);
			return date;
		}

		if (object instanceof String) {
			return stringToDate((String) object);
		}

		return null;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static Date stringToDate(String s) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			return sdf.parse(s);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date calculaDias(int i) {
		Date hoje = new Date();

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hoje);
		calendar.add(Calendar.DAY_OF_MONTH, i);

		return calendar.getTime();
	}

	/**
	 * Obtem o primeiro dia do mes
	 * 
	 * @return
	 */
	public static Date primeiroDiaDoMes() {
		Calendar primeiroDia = Calendar.getInstance();
		primeiroDia.set(Calendar.DAY_OF_MONTH, 1);
		return primeiroDia.getTime();
	}

	public static String removeCaracteresInvalidos(String ret) {
		// Remove todos . da string
		ret = ret.replaceAll("\\.?", "");
		// Remove todas , da string
		ret = ret.replaceAll(",?", "");
		// Remove todas - da string
		ret = ret.replaceAll("-?", "");
		// Remove todas : da string
		ret = ret.replaceAll(":?", "");
		// Remove todas ( da string
		ret = ret.replaceAll("\\(?", "");
		// Remove todas ) da string
		ret = ret.replaceAll("\\)?", "");
		// Remove todas � da string
		ret = ret.replaceAll("�?", "");
		// Remove todas | da string
		ret = ret.replaceAll("\\|?", "");
		// Remove todas \ da string
		ret = ret.replaceAll("\\\\?", "");

		return ret;
	}

	/**
	 * 
	 * @return
	 */
	public static Date hoje() {
		return new Date();
	}

	/**
	 * Cria um caminho com base na data passada, exemplo 2016-01-25 Ficaria
	 * 2016/01/25
	 * 
	 * @param hoje
	 * @return
	 */
	public static String criarCaminhoArquivoPorData(Date data) {
		String retorno = null;
		String ano, mes, dia;
		final String pathSeparator = File.separator;

		SimpleDateFormat dd = new SimpleDateFormat("dd");
		SimpleDateFormat mm = new SimpleDateFormat("MM");
		SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");

		ano = yyyy.format(data);
		mes = mm.format(data);
		dia = dd.format(data);

		retorno = ano + pathSeparator + mes + pathSeparator + dia + pathSeparator;

		return retorno;
	}

	/**
	 * 
	 * @param tipo
	 * @param valor
	 * @return
	 * @throws ParseException
	 */
	public static String getDatePart(String tipo, String valor) throws ParseException {
		String retorno = "";
		String[] data = valor.split("/");

		if (data.length == 3) {
			retorno = StringUtil.organizaNomesDePastas(tipo, data);
		} else if (data.length == 2) {
			retorno = StringUtil.organizaNomesDePastasMesAno(tipo, data);
		}

		return retorno;
	}

	/**
	 * M�todo responsavel por organizar o nome das pastas na arvore de
	 * documentos
	 * 
	 * JAN/2015 = Na arvore fica Janeiro 01/2015 = Na arvore fica Janeiro
	 * 
	 * 01/02/2015 = Na arvore fica Fevereiro
	 * 
	 */
	public static String organizaNomesDePastas(String tipo, String[] data) {
		String retorno = "";
		try {
			switch (tipo) {
			case "yyyy":
				// retorno = String.valueOf(data.getYear());
				retorno = data[2].trim();
				break;
			case "MM":
				// retorno = String.valueOf(data.getMonth());
				retorno = data[1].trim();
				break;
			case "dd":
				// retorno = String.valueOf(data.getDay());
				retorno = data[0].trim();
				break;
			case "mes":
				// switch (data.getMonth())
				String s = data[1].trim();
				try {

					final Integer m = Integer.parseInt(data[1].trim());
					s = String.valueOf(m);
				} catch (Exception n) {
				}

				switch (s) {
				case "1":
					retorno = "JANEIRO";
					break;
				case "2":
					retorno = "FEVEREIRO";
					break;
				case "3":
					retorno = "MAR�O";
					break;
				case "4":
					retorno = "ABRIL";
					break;
				case "5":
					retorno = "MAIO";
					break;
				case "6":
					retorno = "JUNHO";
					break;
				case "7":
					retorno = "JULHO";
					break;
				case "8":
					retorno = "AGOSTO";
					break;
				case "9":
					retorno = "SETEMBRO";
					break;
				case "10":
					retorno = "OUTUBRO";
					break;
				case "11":
					retorno = "NOVEMBRO";
					break;
				case "12":
					retorno = "DEZEMBRO";
					break;
				case "JAN":
					retorno = "JANEIRO";
					break;
				case "FEV":
					retorno = "FEVEREIRO";
					break;
				case "MAR":
					retorno = "MAR�O";
					break;
				case "ABR":
					retorno = "ABRIL";
					break;
				case "MAI":
					retorno = "MAIO";
					break;
				case "JUN":
					retorno = "JUNHO";
					break;
				case "JUL":
					retorno = "JULHO";
					break;
				case "AGO":
					retorno = "AGOSTO";
					break;
				case "SET":
					retorno = "SETEMBRO";
					break;
				case "OUT":
					retorno = "OUTUBRO";
					break;
				case "NOV":
					retorno = "NOVEMBRO";
					break;
				case "DEZ":
					retorno = "DEZEMBRO";
					break;
				default:
					retorno = data[1].trim();
					break;
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	/**
	 * JAN/2015
	 * 
	 * @param tipo
	 * @param data
	 * @return
	 */
	public static String organizaNomesDePastasMesAno(String tipo, String[] data) {
		String retorno = "";
		try {
			switch (tipo) {
			case "yyyy":
				// retorno = String.valueOf(data.getYear());
				retorno = data[1].trim();
				break;
			case "MM":
				// retorno = String.valueOf(data.getMonth());
				retorno = data[0].trim();
				break;
			case "mes":
				// switch (data.getMonth())
				String s = data[0].trim();
				try {

					final Integer m = Integer.parseInt(data[1].trim());
					s = String.valueOf(m);
				} catch (Exception n) {
				}

				switch (s) {
				case "1":
					retorno = "JANEIRO";
					break;
				case "2":
					retorno = "FEVEREIRO";
					break;
				case "3":
					retorno = "MAR�O";
					break;
				case "4":
					retorno = "ABRIL";
					break;
				case "5":
					retorno = "MAIO";
					break;
				case "6":
					retorno = "JUNHO";
					break;
				case "7":
					retorno = "JULHO";
					break;
				case "8":
					retorno = "AGOSTO";
					break;
				case "9":
					retorno = "SETEMBRO";
					break;
				case "10":
					retorno = "OUTUBRO";
					break;
				case "11":
					retorno = "NOVEMBRO";
					break;
				case "12":
					retorno = "DEZEMBRO";
					break;
				case "JAN":
					retorno = "JANEIRO";
					break;
				case "FEV":
					retorno = "FEVEREIRO";
					break;
				case "MAR":
					retorno = "MAR�O";
					break;
				case "ABR":
					retorno = "ABRIL";
					break;
				case "MAI":
					retorno = "MAIO";
					break;
				case "JUN":
					retorno = "JUNHO";
					break;
				case "JUL":
					retorno = "JULHO";
					break;
				case "AGO":
					retorno = "AGOSTO";
					break;
				case "SET":
					retorno = "SETEMBRO";
					break;
				case "OUT":
					retorno = "OUTUBRO";
					break;
				case "NOV":
					retorno = "NOVEMBRO";
					break;
				case "DEZ":
					retorno = "DEZEMBRO";
					break;
				default:
					retorno = data[0].trim();
					break;
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;

	}

	public static String getIp() {
		InetAddress thisIp;
		String ip = null;
		try {
			thisIp = InetAddress.getLocalHost();
			if (thisIp == null) {
				logger.error("Nao pegou o IPHost da M�quina ");
				return "";
			}
			ip = thisIp.getHostAddress();

		} catch (UnknownHostException e) {
			logger.error(e.getMessage());
		}
		return ip;
	}

	public static Timestamp hojeDataHoraTimestamp() {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		return time;
	}

	/**
	 * Gera um texto aleat�rio
	 * 
	 * @param minTextSize
	 * @param maxTextSize
	 * @param uppercaseLetters
	 * @param lowercaseLetters
	 * @param digits
	 * @return
	 */
	public static String generateRandomText(int minTextSize, int maxTextSize, boolean uppercaseLetters,
			boolean lowercaseLetters, boolean digits) {
		final int FIRST_UPPERCASE_LETTER = 'A';
		final int FIRST_LOWERCASE_LETTER = 'a';
		final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;

		Random rnd = new Random();

		int textSize = minTextSize + rnd.nextInt(maxTextSize);
		if (textSize > maxTextSize) {
			textSize = maxTextSize;
		}

		int currentLength = 0;

		StringBuilder text = new StringBuilder(textSize);
		ArrayList<Object> textList = new ArrayList<Object>(textSize);

		if (digits) {
			int noOfDigits = 0;
			if (uppercaseLetters == false && lowercaseLetters == false) {
				noOfDigits = textSize - currentLength;
			} else {
				noOfDigits = rnd.nextInt(textSize);
			}
			for (int i = 0; i < noOfDigits; i++) {
				textList.add(new Integer(rnd.nextInt(9)));
			}
			currentLength = noOfDigits;
		}

		if (uppercaseLetters) {
			int noOfUpper = 0;
			if (lowercaseLetters == false) {
				noOfUpper = textSize - currentLength;
			} else {
				noOfUpper = rnd.nextInt(textSize - currentLength);
			}

			for (int i = 0; i < noOfUpper; i++) {
				textList.add(
						new Character((char) (FIRST_UPPERCASE_LETTER + rnd.nextInt(NUMBER_OF_LETTERS_IN_ALPHABET))));
			}
			currentLength += noOfUpper;
		}

		if (lowercaseLetters) {
			int noOfLower = textSize - (currentLength);
			for (int i = 0; i < noOfLower; i++)
				textList.add(
						new Character((char) (FIRST_LOWERCASE_LETTER + rnd.nextInt(NUMBER_OF_LETTERS_IN_ALPHABET))));
		}

		Collections.shuffle(textList);

		for (Object value : textList) {
			text.append(value);
		}

		return text.toString();
	}

	/**
	 * Verifica se a string � um n�mero.
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isNumeric(String valor) {
		if (valor != null) {
			for (int i = 0; i < valor.length(); i++) {
				if (!Character.isDigit(valor.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Valida CPF
	 * 
	 * @param strCpf
	 * @return
	 */
	public static boolean isCPF(String strCpf) {
		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();

			// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
			// e assim por diante.
			d1 = d1 + (11 - nCount) * digitoCPF;

			// para o segundo digito repita o procedimento incluindo o primeiro
			// digito calculado no passo anterior.
			d2 = d2 + (12 - nCount) * digitoCPF;
		}
		;

		// Primeiro resto da divis�o por 11.
		resto = (d1 % 11);

		// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
		// menos o resultado anterior.
		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		// Segundo resto da divis�o por 11.
		resto = (d2 % 11);

		// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
		// menos o resultado anterior.
		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		// Digito verificador do CPF que est� sendo validado.
		String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo
		// resto.
		return nDigVerific.equals(nDigResult);
	}

	public static String getRGDigit(String rg) {
		String ret;
		int sum = 0;
		int j = 2;

		for (int i = rg.length(); i > 0; i--) {
			sum += (Integer.parseInt(rg.substring(i - 1, i)) * j);
			j++;
			if (j > 10) {
				j = 2;
			}
		}

		sum = (sum % 11);

		if (sum == 10) {
			ret = "X";
		} else {
			ret = sum + "";
		}

		return ret;
	}

	public static String removeAcentuacao(String texto) {
		String newTexto = texto;
		newTexto = newTexto.replace('�', 'a');
		newTexto = newTexto.replace('�', 'a');
		newTexto = newTexto.replace('�', 'a');
		newTexto = newTexto.replace('�', 'a');
		newTexto = newTexto.replace('�', 'e');
		newTexto = newTexto.replace('�', 'e');
		newTexto = newTexto.replace('�', 'i');
		newTexto = newTexto.replace('�', 'o');
		newTexto = newTexto.replace('�', 'o');
		newTexto = newTexto.replace('�', 'o');
		newTexto = newTexto.replace('�', 'u');
		newTexto = newTexto.replace('�', 'u');
		newTexto = newTexto.replace('�', 'c');
		newTexto = newTexto.replace('�', 'y');

		newTexto = newTexto.replace('�', 'A');
		newTexto = newTexto.replace('�', 'A');
		newTexto = newTexto.replace('�', 'A');
		newTexto = newTexto.replace('�', 'A');
		newTexto = newTexto.replace('�', 'A');
		newTexto = newTexto.replace('�', 'E');
		newTexto = newTexto.replace('�', 'E');
		newTexto = newTexto.replace('�', 'I');
		newTexto = newTexto.replace('�', 'O');
		newTexto = newTexto.replace('�', 'O');
		newTexto = newTexto.replace('�', 'O');
		newTexto = newTexto.replace('�', 'U');
		newTexto = newTexto.replace('�', 'U');
		newTexto = newTexto.replace('�', 'C');
		newTexto = newTexto.replace('�', 'Y');
		texto = newTexto;

		return texto;
	}

	/**
	 * Pega somente o nome do arquivo no caminho
	 * 
	 * @param nameFile
	 * @return
	 */
	public static String getOnlyName(String nameFile) {
		String newName = "";
		if (nameFile.lastIndexOf("\\") > -1) {
			newName = nameFile.substring(nameFile.lastIndexOf("\\") + 1, nameFile.length());
		} else if (nameFile.lastIndexOf("/") > -1) {
			newName = nameFile.substring(nameFile.lastIndexOf("/") + 1, nameFile.length());
		} else {
			newName = nameFile;
		}

		return newName;
	}

	/**
	 * Feature [SDM 63478] Erro ao exportar resultados da Busca R�pida Content
	 * PDG-GOLDFARB<BR>
	 * M�todo respons�vel por obter os campos de um ResultSet <BR>
	 * 
	 * @since 25/02/2014 11:12:23
	 * @author Renato Vieira<BR>
	 */
	public static ArrayList<String> obtemCamposResultSet(ResultSet rs) throws Exception {

		ArrayList<String> result = new ArrayList<String>();

		ResultSetMetaData rsmd = rs.getMetaData();

		int numColumns = rsmd.getColumnCount();

		for (int i = 1; i < numColumns + 1; i++) {

			String columnName = rsmd.getColumnName(i);

			result.add(columnName);
		}

		return result;
	}

	public static String getString(Object object) {

		if (object == null) {
			return null;
		}

		if (object instanceof String) {
			return (String) object;
		}

		return object.toString();
	}

	/**
	 * retorno o booleano do objeto.
	 * 
	 * @param object
	 * @return
	 */
	public static boolean getBoolean(Object object) {
		Integer i = getInteger(object);

		if (i != null) {
			return i.intValue() != 0;
		}

		return false;
	}

	public static String retiraEspacoCaracteresEspeciais(String stringFonte) {
		String passa = stringFonte;
		passa = passa.replaceAll("~", "");
		passa = passa.replaceAll("�", "");
		passa = passa.replaceAll("--", "");
		passa = passa.replaceAll("�", "");
		passa = passa.replaceAll("\\|", "");
		passa = passa.replaceAll("\\\\", "");
		passa = passa.replaceAll("[+=*&%$#@!_]", "");
		passa = passa.replaceAll("['\"]", "");
		passa = passa.replaceAll("[<>()\\{\\}]", "");
		passa = passa.replaceAll("['\\\\.,()|/]", "");
		passa = passa.replaceAll("^\\s+", "");
		passa = passa.replaceAll("\\s+$", "");
		return passa;
	}

	/**
	 * 
	 * @param str
	 * @param i
	 * @return
	 */
	public static String quebraString(String str, int i) {
		if (isBlankOrNull(str)) {
			return null;
		}

		if (str.length() > i) {
			return str.substring(0, i);
		}

		return str;
	}

}
