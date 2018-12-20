package com.br.loja.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe de constantes do sistema.
 * @author lmonteiro
 * 
 */
public class Constantes {
	
	public static final String USUARIO_DA_SESSAO = "usuario";
	
	/**
	 * 
	 */
	public static final String SERVICE_LOTE = "loteService";
	/**
	 * 
	 */

	public static final String PARAM_APPLICATION_CONTEXT = "PARAM_APPLICATION_CONTEXT";
	public static final String PARAM_APPLICATION_PROPERTIES = "PARAM_APPLICATION_PROPERTIES";
	
	public static final String EFETUOU_LOGIN = "Efetuou login no sistema";

	
	// Constantes guardando modulo
	public static final String MODULO_CONTROLE_QUALIDADE = "CONTROLE DE QUALIDADE";
	public static final String MODULO_INDEXER = "INDEXER";
	public static final String MODULO_REDIGITALIZAR_AGUARDANDO = "REDIGITALIZANDO";
	public static final String MODULO_REDIGITALIZAR = "REDIGITALIZAR";
	
	public static final int ID_MODULO_TRATAR = 18;
	public static final Integer ID_MODULO_INDEXER = 10;
	public static final Integer ID_MODULO_OCR = 22;
	public static final Integer ID_MODULO_CONTENT = 17;

	public static final Integer ID_MODULO_CONTROLE_QUALIDADE = 12;
	public static final int ID_MODULO_OPERACIONAL = 16;
	public static final int ID_MODULO_REDIGITALIZAR = 21;
	public static final int ID_MODULO_TRATAR_VRS = 28;
	
	// A��ES DO SISTEMA
	public static final Integer ACAO_SUSPENDER = 17;
	public static final Integer ACAO_ALTERAR = 2;
	public static final Integer ACAO_REMOVER = 3;
	public static final Integer ACAO_INCLUIR = 1;
	
	public static final String ORIGEM_IMAGEM_DESCRICAO_INDEXER = "INDEXER";
	public static final String ORIGEM_IMAGEM_DESCRICAO_TRATAR = "TRATAR";
	public static final String ORIGEM_IMAGEM_DESCRICAO_ARVORE = "ARVORE_DOCUMENTOS";
	public static final String ORIGEM_IMAGEM_DESCRICAO_ASSINATURA = "ASSINATURA_DIGITAL";
	public static final String ORIGEM_IMAGEM_DESCRICAO_TRATAR_VRS = "Tratar VRS";
	
	
	public static final String TEXTO_PROCESSO_REPROVADO = "Processo Reprovado";
	public static final String LOG_TEXTO_SUSPENDEU_O_PROCESSO = "SUSPENDEU PROCESSO";
	
	public static final String LOG_TEXTO_SUSPENDEU_O_LOTE = "SUSPENDEU LOTE";
	public static final String LOG_TEXTO_ALTEROU_O_PROCESSO = "ALTEROU O PROCESSO";
	public static final String TEXTO_IMAGEM_EXCLUIDA = "Imagem Excluida";
	public static final Integer ID_MOTIVO_REPROVACAO_AUTOMATICA = 10; 
	public static final Integer ID_MOTIVO_REPROVACAO_POR_DOCUMENTO = 22; 
	public static final Integer ID_MOTIVO_REPROVACAO_POR_PROCESSO = 14;
	
	public static final String LOG_TEXTO_ALTEROU_O_DOCUMENTO = "ALTEROU O DOCUMENTO";
	public static final String LOG_TEXTO_ALTEROU_A_IMAGEM = "ALTEROU A IMAGEM";
	
	// STATUS DO PROCESSO
	public static final Long STATUS_PROCESSO_DISPONIVEL 		= 0L;
	public static final Long STATUS_PROCESSO_PROCESSANDO		= 1L;
	public static final Long STATUS_PROCESSO_SUSPENSO 			= 2L;
	public static final Long STATUS_PROCESSO_ERRO 				= 3L;
	public static final Long STATUS_PROCESSO_FECHADO 			= 4L;
	public static final Long STATUS_PROCESSO_EXCLUIDO 			= 5L;
	public static final Long STATUS_PROCESSO_RESERVADO 			= 6L;

	
	// Controle de Qualidade
	public static final String MOTIVO_REPROVACAO_PROCESSO = "Reprova��o por Processo";
	public static final String MOTIVO_REPROVACAO_AUTOMATICA = "Rejeitado Automaticamente";
	
	public static final String MOTIVO_REPROVACAO_DOCUMENTO = "Reprova��o por Documento";

	public static final String	VERSAO_CONTENT 								= "8.16.19";
	
	//Plano de classifica��o
	public static final int 	PERMANENTE 									= 1;
	public static final int 	DESCARTE 									= 2;
	
	//DATABASE
	public static final int 	SQLSERVER									= 0;
	public static final int 	ORACLE										= 1;
	public static final int     POSTGRE                                     = 3;
	public static final String	DESC_SQLSERVER								= "S";
	public static final String 	DESC_ORACLE									= "O";
	public static final String  DESC_POSTGRE                                = "P";
	public static final String 	DAY_DATE_ORACLE 							= " to_char( d.datacriacao,'DD' ) ";
	public static final String 	DAY_DATE_SQLSERVER 							= " day(d.datacriacao) ";		
	public static final String  DAY_DATE_POSTGRES							= " date_part('day', d.datacriacao)";
	
	//A��es para Log
	public static final int		ACTION_INSERIR								= 1;
	public static final int		ACTION_ALTERAR								= 2;
	public static final int		ACTION_REMOVER								= 3;
	public static final int		ACTION_CONSULTAR							= 4;
	public static final int		ACTION_LISTAR								= 5;
	public static final int		ACTION_LOGIN								= 6;
	public static final int		ACTION_LOGIN_CERTIFICADO					= 100;
	public static final int		ACTION_LOGOUT								= 7;
	public static final int		ACTION_EDITAR								= 8;
	public static final int		ACTION_VISUALIZAR							= 9;
	public static final int		ACTION_CIVIL								= 10;
	public static final int		ACTION_CRIMINAL								= 11;	
	public static final int		ACTION_INEXISTENTE							= 13;
	public static final int		ACTION_ACEITAR								= 14;
	public static final int		ACTION_NEGAR								= 15;
	public static final int		ACTION_ERRO									= 99;
	public static final int		ACTION_DOWNLOAD								= 16;
	public static final int     ACTION_SUCESSO              				= 17;	
	

	//Funcionalidades para Log
	public static final int		FUNCTION_USUARIO							= 1;
	public static final int		FUNCTION_GRUPO								= 2;
	public static final int		FUNCTION_NIVEL_HIERARQUICO					= 3;
	public static final int		FUNCTION_PASTA								= 4;
	public static final int		FUNCTION_DOCUMENTO							= 5;
	public static final int		FUNCTION_TIPO_DOCUMENTO						= 6;
	public static final int		FUNCTION_TIPO_PASTA							= 7;
	public static final int		FUNCTION_IMAGEM								= 8;
	public static final int		FUNCTION_PERFIL								= 9;
	public static final int		FUNCTION_JOB								= 10;
	public static final int		FUNCTION_TIPO_JOB							= 11;
	public static final int		FUNCTION_PERMISSAO_PASTA_DOCUMENTO			= 12;
	public static final int		FUNCTION_BUSCA_AVANCADA						= 13;
	public static final int		FUNCTION_LOG								= 14;
	public static final int		FUNCTION_BLOG_DOCUMENTO						= 15;
	public static final int		FUNCTION_CARGO								= 16;
	public static final int		FUNCTION_LOCALIDADE							= 17;
	public static final int		FUNCTION_DIVISAO							= 18;
	public static final int		FUNCTION_ETIQUETAS							= 19;
	public static final int		FUNCTION_DEPARTAMENTO						= 20;
	public static final int		FUNCTION_REMOVER_LOGICAMENTE_DOCUMENTO		= 21;
	public static final int		FUNCTION_HISTORICO_DOCUMENTO				= 22;
	public static final int		FUNCTION_RELATORIO							= 23;
	public static final int		FUNCTION_PARAMETROS							= 24;
	public static final int		FUNCTION_PESQUISA_TRIAGEM					= 25;
	public static final int		FUNCTION_ALTERAR_IMAGEM 					= 26;
	public static final int     FUNCTION_CONTAGEM_IMAGEM		            = 27;
	public static final int     FUNCTION_ALERTA_EMAIL						= 28;
	public static final int     FUNCTION_VISUALIZAR_CONFIGURACAO_LICENCAS	= 29;	
	public static final int     FUNCTION_EDITAR_CONFIGURACAO_LICENCAS		= 30;	
	public static final int     FUNCTION_EASY		= 32;	
	
	
	/**
	 * PERMISSOES
	 */
	public static final String CADASTROS = "CADASTROS";
	public static final String CONFIGURACOES = "CONFIGURA��ES";
	public static final String CADASTRO_USUARIO = "CADASTRO DO USU�RIO";
	public static final String CADASTRO_GRUPO   = "CADASTRO DO GRUPO";
	public static final String CADASTRO_NIVEL_HIERARQUICO = "CADASTRO N�VEL HIER�RQUICO";
	public static final String CADASTRO_DA_PASTA = "CADASTRO DA PASTA";
	public static final String CADASTRO_DO_DOCUMENTO = "CADASTRO DO DOCUMENTO";
	public static final String CADSATRO_DO_TIPO_DE_DOCUMENTO = "CADASTRO DO TIPO DE DOCUMENTO";
	public static final String CADASTRO_DO_TIPO_DE_PASTA = "CADASTRO DO TIPO DE PASTA";
	public static final String VISUALIZACAO_OU_IMPRESSAO_DE_IMAGENS = "VISUALIZA��O OU IMPRESS�O DE IMAGENS";
	public static final String PERFIL_DO_USUARIO = "PERFIL DO USU�RIO";
	public static final String JOB = "JOB";
	public static final String TIPO_JOB = "TIPOJOB";
	public static final String PERFIL_DE_PASTA_E_DOCUMENTO = "PERFIL DE PASTA E DOCUMENTO";
	public static final String CADASTRO_DA_BUSCA_AVANCADA = "CADASTRO DA BUSCA AVAN�ADA";
	public static final String EXPORTAR_LOG = "EXPORTAR LOG";
	public static final String BLOG_DO_DOCUMENTO = "BLOG DO DOCUMENTO";
	public static final String CADASTRO_DE_CARGO = "CADASTRO DE CARGO";
	public static final String CADASTRO_DE_LOCALIDADE = "CADASTRO DE LOCALIDADE";
	public static final String CADASTRO_DE_DIVISAO_SECCIONAL = "CADASTRO DE DIVIS�O/SECCIONAL";
	public static final String CADASTRO_DE_DEPARTAMENTO = "CADASTRO DE DEPARTAMENTO";
	public static final String DEPARTAMENTO = "DEPARTAMENTO";
	public static final String REMOVER_DOCUMENTO_LOGICAMENTE = "REMOVER DOCUMENTO LOGICAMENTE";
	public static final String HISTORICO_DE_DOCUMENTO = "HIST�RICO DE DOCUMENTO";
	public static final String RELATORIO = "RELAT�RIO";
	public static final String PARAMETROS = "PARAMETROS";
	public static final String PESQUISA_TRIAGEM_REINDEX = "PESQUISA TRIAGEM REINDEX";
	public static final String ALTERAR_IMAGEM_REINDEX = "ALTERAR IMAGEM REINDEX";
	public static final String VISUALIZAR_CONFIGURACAO_DE_LICENCAS = "VISUALIZAR CONFIGURA��O DE LICEN�AS";
	public static final String EDITAR_CONFIGURACAO_DE_LICENCAS = "EDITAR CONFIGURA��O DE LICEN�AS";
	public static final String CADASTRO_DE_LOTE = "CADASTRO DE LOTE";
	public static final String MONITOR_DE_PROCESSO = "MONITOR DE PROCESSO";
	public static final String RELATORIOS = "RELAT�RIOS";
	public static final String VISUALIZADOR_DE_PROCESSO = "VISUALIZADOR DE PROCESSO";
	public static final String EASY = "EASY";
	/**
	 * FIM PERMISSOES
	 */

	/**
	 * 
	 * Dados utilizado pelo Blockchain 
	 * 
	 */


	public static String TOKEN = "2d2d2d2d2d424547494e205253412050524956415445204b45592d2d2d2d2d0a4d4949457041494241414b43415145416f44486a72547971774b505a356576706c63442f4d3351356c7169377a61786747722b2b794d326b4d7176387a68464f0a4a37494c5176322f7435796f53496e78532f536f584779326a7532516d34795674643274563134626f31512f75303974612f54434c48616b32784e46547973300a327779614a50305169336d6c4c717a6f677a634369776c72634973354259686150354d2f764c4f364b4e3735387038793530643745416b4836524f77685655410a636d354d4e6c565a4e78596f716f36614e6869393650482b6a62355356465a766544632b302f7855366c794734414538756d33524f616844684247692f5769790a3471492f56644b31626f486369324e3234356e5652416541704d6c726a7a4b6c33644e6f6c5565594e567a4c45624d6c633844745133577354736b48776942320a41503074676e4c34564e5a354a434b50393774794e5949393232716a7a374e636f506b616c51494441514142416f494241444b4869676c61325946714c5a45590a6d4e566a797875767a58703450735468576d38566a46684b685542326634654162656158676e586646466f57542f365268457378494f6f4759493830344367770a634169746f372b724c347956526f554f794c5545767a72484d626a6f6d7a5164724d3572617a4f2f6e7a68665a6e73536a30545556546b462f353341544877790a526b564862524e596e5a2f47745a43534a72784e4438512f46502b76646e302b4d5850363631727a74307346754c332b42416c436e636167455274546847456b0a4f546b323638397446545a596b65347139366f4e447a595a637951616b705333652f596a524164504555784c65384a2f376d6945703962686f4a72454e6539560a2f514164376a6133573551617a644a3257742b674835416766506c55465175722b6c6b4b2b45527477616844465452324a397473356541524d326a727372674f0a703766695951454367594541797839384951394f3868676541514c774e6e6e4577526d59514338504f69776d7a357641425076584c4e6653712b7a646d5168690a4658502b367341796a6474326f67654c73764b366c586134514b5636702b2b74676b7036774c2b31724b7873696d584372733658726b7955456557594568486a0a724d6f514566784d3279622b55556c72426e4843504977484e41747a2b784741437351794f742b6f4c6f5555764f4b6341352f4a6e69734367594541796557580a54626e42634e5471505557664b5a2f633244714a684c36712f6b75394b55305766466d79314f446f4e7a624a5641415578783070504e4e504a39476d4e772f6b0a754170334d4e2b6f30474a75493871476c704c77364a576a6b5842676f72503953546148505a684a4741436862652f6f5261714c6e61635053755132557748500a6842716f4766784b5a3069496b544c39554b794b7951487a4c6c483879723551424f6c49696a38436759414d3359366f4c57634c73486c65435169622b7252360a6f70746848566e796a6b3962415074316c566e347269626132754c695359536b355462314f583036505064547066533050656d52672f614271626d4f483445320a366d37422f4b4b4f4d46476a706e5268544261525a4b7051512b47513632386e52356b692b6e3848746e32504f6e343735304b7451525648743533392f6772460a4938346d716e6e6c6b477053324775585579796242774b42675143617a4c2b43353938717251566772325947327a7a5153616d784c795161554759634b6241490a37686d513456554c4b4b576245326a61396a2f744644504832785976643638746356444d4632447654646b5739697a56664a72634b676538397359525769486c0a4a6272782f6a5a6c4165374552554c3554336333444b564d44636964516e4569332f4674347951464a7663584a567057706354507441414a7a764564586d67710a4b39666a72774b426751436f44533134717a2f382f655a524271756f6b4e373178614a6930615970396344616d435130763472427545304136594c594367426f0a664368506568716d4239495a2f36316462354577426d396b7963614f6c78674e545875437a414f527742526441563550357277352f6a745a76347965704557750a624d7757424e5874577563495874314a6f586f666d7836486d5a6c527473724e555a50673275314248304d4146394d41353054566d413d3d0a2d2d2d2d2d454e44205253412050524956415445204b45592d2d2d2d2d0a";

	public static Integer ACCOUNT = 17; // Integer | API ID for Account where
	// the coins must be spend.

	public static String USER = "tci@tcibpo.com.br"; // String | API user name.

	public static String PASSWORD = "tcibpo"; // String | API user password.

	public static String COIN = "bitcoin"; // String | the coin name -
	// bitcoin/litecoin.

	public static Integer TEST = 1; // Teste

	public static Integer PRODUCAO = 0; // Produ��o

	/**
	 * 
	 * Fim dados utilizado pelo Blockchain 
	 * 
	 */
	
	//Viewer
	public static final int 	VIEWER_LIGHT 								= 1;
	public static final int 	VIEWER_FULL 								= 2;
	
	//Tipos
	public static final int		TIPO_DOCUMENTO								= 1;
	public static final int		TIPO_PASTA									= 2;
	public static final int		TIPO_NIVEL									= 3;
	
	//Tipos de �ndice
	public static final int		INDICE_COMBO								= 0;
	public static final int		INDICE_NUMERICO								= 1;
	public static final int		INDICE_ALFANUMERICO							= 2;
	public static final int		INDICE_CARACTER								= 3;
	public static final int		INDICE_CHAR_ESPECIAL						= 4;
	public static final int		INDICE_DATA_RANGE							= 5;
	public static final int		INDICE_MASTER								= 6;
	public static final int		INDICE_DETAIL								= 7;
	
	//Ordena��o indices
	public static final String	CRESCENTE									= "asc";
	public static final String	DECRESCENTE 								= "desc";
	
	//Solicita��o SisDoc
	public static final String 	SISDOC_INITIAL_PAGE							= "solicitacao_servico_content.aspx";
	public static final String 	SISDOC_PROTOCOL_PAGE						= "solicitacao_servicoResultado.aspx";

	//Imagens dos Relat�rios
	public static final String	LOGO_CONTENT								= "/_images/logoContent.gif";
	public static final String	ICONE_DOCS									= "/_images/icone-docs2.gif";
	public static final String	LOGO_SSP									= "/_images/logo_Relatorio.jpg";

	//Caminho para os Relat�rios
	public static final String	RELATORIO_BASE_DIR							= "/WEB-INF/classes/tci/content/web/reports/";
	public static final String	RELATORIO_LOG								= RELATORIO_BASE_DIR + "relatorioLog.jasper";
	public static final String	RELATORIO_CONTAGEM							= RELATORIO_BASE_DIR + "relatorioContagem.jasper";
	public static final String	RELATORIO_ACESSO							= RELATORIO_BASE_DIR + "relatorioAcessoGrafico.jasper";
	public static final String	RELATORIO_CONSULTA							= RELATORIO_BASE_DIR + "relatorioConsultaGrafico.jasper";
	public static final String	RELATORIO_VISUALIZACAO						= RELATORIO_BASE_DIR + "relatorioVisualizacaoGrafico.jasper";
	public static final String	RELATORIO_ACESSO_LOG_USUARIO				= RELATORIO_BASE_DIR + "relatorioAcessoGraficoUsuario.jasper";
	public static final String	RELATORIO_CONSULTA_LOG_USUARIO				= RELATORIO_BASE_DIR + "relatorioConsultaGraficoUsuario.jasper";
	public static final String	RELATORIO_VISUALIZACAO_LOG_USUARIO			= RELATORIO_BASE_DIR + "relatorioVisualizacaoGraficoUsuario.jasper";
	public static final String	RELATORIO_ACESSO_LOG_GRUPO					= RELATORIO_BASE_DIR + "relatorioAcessoGraficoGrupo.jasper";
	public static final String	RELATORIO_CONSULTA_LOG_GRUPO				= RELATORIO_BASE_DIR + "relatorioConsultaGraficoGrupo.jasper";
	public static final String	RELATORIO_VISUALIZACAO_LOG_GRUPO			= RELATORIO_BASE_DIR + "relatorioVisualizacaoGraficoGrupo.jasper";
	public static final String	RELATORIO_EMISSAO_DE_ETIQUETA				= RELATORIO_BASE_DIR + "relatorioBarra.jasper";
	public static final String	RELATORIO_GRAFICO_POR_DATA					= RELATORIO_BASE_DIR + "relatorioConsultaGraficoUsuarioPorDataTotalizado.jasper";		;
	public static final String	RELATORIO_CONSULTA_POR_HORA					= RELATORIO_BASE_DIR + "relatorioConsultaGraficoPorHoraTipoDeAcaoTotalizado.jasper";
	public static final String	RELATORIO_ACESSO_POR_HORA					= RELATORIO_BASE_DIR + "relatorioAcessoGraficoPorHoraTotalizado.jasper";
	public static final String	RELATORIO_ACESSO_LOG_USUARIO_POR_HORA		= RELATORIO_BASE_DIR + "relatorioAcessoGraficoUsuarioPorDataTotalizado.jasper";
	public static final String	RELATORIO_VISUALIZACAO_POR_HORA				= RELATORIO_BASE_DIR + "relatorioVisualizacaoGraficoPorHoraTotalizado.jasper";
	public static final String	RELATORIO_VISUALIZACAO_LOG_USUARIO_POR_DATA	= RELATORIO_BASE_DIR + "relatorioVisualizacaoGraficoUsuarioPorDataTotalizado.jasper";
	public static final String	RELATORIO_IMAGENS							= RELATORIO_BASE_DIR + "relatorioImagens.jasper";
	public static final String	RELATORIO_DOCUMENTOS						= RELATORIO_BASE_DIR + "relatorioDocumentos.jasper";
	public static final String	RELATORIO_PASTAS							= RELATORIO_BASE_DIR + "relatorioPastas.jasper";
	public static final String	RELATORIO_DOCUMENTOS_INSERIDOS				= RELATORIO_BASE_DIR + "relatorioDocumentosInseridos.jasper";
	public static final String	RELATORIO_HISTORICO							= RELATORIO_BASE_DIR + "relatorioHistorico.jasper";
	public static final String  RELATORIO_USUARIOS                          = RELATORIO_BASE_DIR + "relatorioUsuarios.jasper";
	public static final String  RELATORIO_TIPOSDOCUMENTO                    = RELATORIO_BASE_DIR + "relatorioTiposDocumento.jasper";
	public static final String	SOLICITACAO_SENHA							= RELATORIO_BASE_DIR + "SolicitacaoSenha.jasper";
	
	//Nome dos relat�rios
	public static final String	NOME_PDF_LOG								= "relatorioLog.pdf";
	public static final String	NOME_PDF_CONTAGEM							= "relatorioContagem.pdf";
	public static final String	NOME_PDF_IMAGENS							= "relatorioImagens.pdf";
	public static final String	NOME_PDF_DOCUMENTOS							= "relatorioDocumentos.pdf";
	public static final String	NOME_PDF_PASTAS								= "relatorioPastas.pdf";
	public static final String	NOME_PDF_BARRAS								= "relatorioBarras.pdf";
	public static final String	NOME_PDF_DOCUMENTOS_INSERIDOS				= "relatorioDocumentosInseridos.pdf";
	public static final String  NOME_XLS_DOCUMENTOS_INSERIDOS				= "relatorioDocumentosInseridos.xls";
	public static final String	NOME_PDF_HISTORICO							= "relatorioHistorico.pdf";
	public static final String  NOME_XLS_USUARIOS                           = "relatorioUsuarios.xls";
	public static final String  NOME_XLS_TIPOSDOCUMENTO                     = "relatorioTiposUsuario.xls";
	public static final String	RELATORIO_TAMANHO_IMG_TIPO_DOCUMENTO		= "relatorioTamanhoImagemTpDoc.jasper";
	
	//XSL
	public static final String	NOME_ESTILO_USUARIO							= RELATORIO_BASE_DIR + "xsl/log_por_usuario.xsl";
	public static final String	NOME_ESTILO									= RELATORIO_BASE_DIR + "xsl/log_por_hora.xsl";
	public static final String	NOME_ESTILO_TIPO							= RELATORIO_BASE_DIR + "xsl/log_por_tipo.xsl";
	
	//ITENS DE SEGURAN�A PARA ACESSO
	public static final String	MARKUP_VIEWER								= "Markup";
	public static final String	PRINT_VIEWER								= "PrintViewer";
	public static final String	ENVIAR_EMAIL_VIEWER							= "EnviarEmailViewer";
	public static final String	ACESSO_PERMITIDO_LOGIN_SEM_CARTAO 			= "BasicLogonWhenCertificateIsRequired";
	public static final String	ITEM_SEGURA					 				= "ItemSeguranca";
	public static final String	EXPORT_IMAGE_PDF							= "ExportImagePDF";
	public static final String	CARGA_PLANILHA								= "CargaPlanilha";
	public static final String	ENVIAR_REINDEX							    = "EnviarReindex";
	
	public static final String	APLICATION_NAME    = "application.name";
	public static final String	APLICATION_VERSION = "application.version";
	public static final String	APLICATION_TITLE = "application.title";
	
	
	/* EXCLUS�O DE PASTAS */
	public static final String PASTA_EXCLUSAO_NOME = "LIXEIRA";
	public static final BigInteger PERMISSAO_PASTA_EXCLUIDAS = BigInteger.ZERO;
	public static final BigInteger PERMISSAO_DEFAULT = new BigInteger("3");
	public static final BigInteger PERMISSAO_ADMIN = new BigInteger("1");
	
	public static final int BUSCA_CORINGA_DESLIGADO 						= 0;
	public static final int BUSCA_CORINGA_INICIO 							= 1;
	public static final int BUSCA_CORINGA_FIM 								= 2;
	public static final int BUSCA_CORINGA_INICIO_E_FIM 						= 3;
	
	public static final String BUSCA_PARAMENTO_DESLIGADO 					= "0";
	public static final String BUSCA_PARAMENTO_INICIO 						= "1";
	public static final String BUSCA_PARAMENTO_FIM 							= "2";
	public static final String BUSCA_PARAMENTO_INICIO_E_FIM 				= "3";

	//public static final String BRAVA_ENABLE_PRINTING						= "BravaEnablePrinting";
	//public static final String BRAVA_ENABLE_MARKUP						= "BravaEnableMarkup";
	
	public static final String VIEWER_JWS 									= "3";
	
	//Alerta Email
		public static final String ALERTA_EMAIL_STATUS_ATIVO					= "A";
		public static final String ALERTA_EMAIL_STATUS_DESC_ATIVO				= "ativo";
		public static final String ALERTA_EMAIL_STATUS_DESATIVADO				= "D";
		public static final String ALERTA_EMAIL_STATUS_DESC_DESATIVADO			= "desativado";
		public static final String ALERTA_EMAIL_STATUS_CANCELADO				= "C";
		public static final String ALERTA_EMAIL_STATUS_DESC_CANCELADO			= "cancelado";
		public static final String ALERTA_EMAIL_PERIODO_DIARIO					= "diario";	
		public static final String ALERTA_EMAIL_PERIODO_SEMANAL					= "semanal";
		public static final String ALERTA_EMAIL_PERIODO_MENSAL					= "mensal";
		public static final String ALERTA_EMAIL_PERIODO_ANUAL					= "anual";
		public static final String ALERTA_EMAIL_TIPO_ALERTA_INDICE				= "INDICE";	
		public static final String ALERTA_EMAIL_TIPO_ALERTA_ACAO				= "ACAO";
		public static final String ALERTA_EMAIL_OPERADOR_FINALIZADO 			= "Finaliza em";
		public static final String ALERTA_EMAIL_OPERADOR_INICIA 			    = "Inicia em";
		public static final String ALERTA_EMAIL_OPERADOR_IGUAL	 				= "Igual a";
		public static final String ALERTA_EMAIL_OPERADOR_CONTEM	 				= "Cont�m";
		public static final String ALERTA_EMAIL_OPERADOR_VENCIMENTO 			= "Vencendo em";
		public static final String ALERTA_EMAIL_CONECTOR_E		 				= "E";
		public static final String ALERTA_EMAIL_CONECTOR_OU		 				= "Ou";
	

	// WEB Service
	public static final String WEBSERVICE = "webService";

	/* TOKEN PASTA E NH PARA CRIAR PASTAS */
	public static final String TOKEN_DIR_PASTA								= "P_";
	public static final String TOKEN_DIR_NH									= "NH_";
	public static final String MODULO_CONTROLE_DE_QUALIDADE = "Controle de Qualidade";
	public static final String MODULO_TRATAMENTO_DE_REPROVACAO = "Tratamento de Reprova��es";
	
	/* CONSTANTES PARA TIPO DE REPROVACAO */
	public static final String TIPO_REPROVACAO_POR_IMAGEM 					= "I";
	public static final String TIPO_REPROVACAO_POR_PROCESSO					= "P";
	public static final String TIPO_REPROVACAO_POR_DOCUMENTO				= "D";
	
	public static final Integer TIPO_REPROVACAO_POR_IMAGEM_ID				= 3;
	
	/* TIPO FILA */ 
	public static final String TIPO_FILA_DIGITALIZACAO_TRATAR = "T";
	public static final String TIPO_FILA_DIGITALIZACAO_LOTE = "L";
	public static final String TIPO_FILA_DIGITALIZACAO_PROCESSO = "P";
	
	/* ATALHOS PARA SELECAO DE DOCUMENTO E PROCESSO */
	public static final String ATALHO_SELECIONA_PROCESSO					= "(CTRL + P)";
	public static final String ATALHO_SELECIONA_DOCUMENTO					= "(CTRL + D)";
	
	public static final int EXISTE_APENAS_UM_NA_LISTA = 1;
	
	public static final int TIPO_DE_PROCESSO		= 3;
	public static final int TIPO_DE_DOCUMENTO		= 1;
	
	/* TIPO DE INCLUSAO DE IMAGEM */
	public static final int INCLUSAO_IMAGEM_APOS_IMAGEM_ATUAL          = 0;
	public static final int INCLUSAO_IMAGEM_ANTES_IMAGEM_ATUAL		   = 1;
	public static final int INCLUSAO_IMAGEM_FINAL_DOCUMENTO 		   = 2;
	public static final int INCLUSAO_IMAGEM_INICIO_DOCUMENTO 	       = 3;
	
	
	/* TIPO DE FILTROS PROCESSOS */
	public static final String FILTRO_PROCESSOS_TODOS_OS_PROCESSOS				= "Todos os Processos";
	public static final String FILTRO_PROCESSOS_PARA_INDEXACAO					= "Processos para Indexa��o";
	public static final String FILTRO_PROCESSOS_MEUS_PROCESSOS					= "Meus Processos";
	public static final String FILTRO_PROCESSOS_PARA_TRATAMENTO_DE_REPROVACAO	= "Processos para Tratamento de Reprova��o";
	public static final String FILTRO_PROCESSOS_FINALIZADOS						= "Processos Finalizados (Content)";
	public static final String FILTRO_PROCESSOS_CQ								= "Processos CQ";

	public static final Integer PRIORIDADE_ALTA = 0;
	
	public static enum OperadorConsulta {
		EQUAL, LIKE
	};
	
	/**
	 * Textos do Log
	 */
	public static final String EFETUOU_TENTATIVA_DE_LOGIN = "Efetuou login no sistema";
	public static final String EFETUOU_CONSULTA_RELATORIO = "Efetuou consulta no relat�rio de Log ";
	public static final String EFETUOU_LOGOUT = "Efetuou Logout";
	public static final String USUARIO_DESLOGADO = "Usu�rio desconectado automaticamente ap�s solicita��o de login pela mesma conta.";
	public static final String CLICOU_EM_OPCAO_DO_MENU = "Clicou na op��o do Menu.";
	
	/**
	 * Monitor de Processos
	 */
	public static final String MONITOR_PROCESSOS_BOTAO_MEUS_PROCESSOS      = "MONITOR_PROCESSOS_BOTAO_MEUS_PROCESSOS";
	public static final String MONITOR_PROCESSOS_BOTAO_TODOS_OS_PROCESSOS  = "MONITOR_PROCESSOS_BOTAO_TODOS_OS_PROCESSOS";
	public static final String MONITOR_PROCESSOS_BOTAO_PROCESSOS_INDEXACAO = "MONITOR_PROCESSOS_BOTAO_PROCESSOS_INDEXACAO";
	public static final String MONITOR_PROCESSOS_BOTAO_PROCESSOS_TRATAR    = "MONITOR_PROCESSOS_BOTAO_PROCESSOS_TRATAR";
	public static final String MONITOR_PROCESSOS_BOTAO_PROCESSOS_CQ        = "MONITOR_PROCESSOS_BOTAO_PROCESSOS_CQ";
	public static final String MONITOR_PROCESSOS_BOTAO_PROCESSOS_FINALIZADOS  = "MONITOR_PROCESSOS_BOTAO_PROCESSOS_FINALIZADOS";
	public static final String MONITOR_PROCESSOS_BOTAO_ABRIR_PROCESSOS        = "MONITOR_PROCESSOS_BOTAO_ABRIR_PROCESSOS";
	
	public static final String MONITOR_PROCESSOS_ABRIR_INDEXER                = "MONITOR_PROCESSOS_ABRIR_INDEXER";
	public static final String MONITOR_PROCESSOS_ABRIR_TRATAR                 = "MONITOR_PROCESSOS_ABRIR_TRATAR";
	public static final String MONITOR_PROCESSOS_ABRIR_CQ                	  = "MONITOR_PROCESSOS_ABRIR_CQ";
	
	public static final String INDEXACAO = "Indexa��o";
	public static final String TRATAMENTO_DE_REPROVACOES = "Tratamento de Reprova��es";

	public static final String EFETUOU_BUSCA_AVANCADA 		= "Efetuou Busca Avan�ada com os seguintes par�metros: ";
	public static final String EFETUOU_BUSCA_RAPIDA   		= "Efetuou Busca Rapida com os seguintes par�metros: ";
	public static final String EFETUOU_BUSCA_CAIXA   		= "Efetuou Busca Caixa com os seguintes par�metros: ";
	public static final String EFETUOU_BUSCA_TEXTUAL  		= "Efetuou Busca Textual com o seguinte par�metro: ";
	public static final String EFETUOU_BUSCA_TODOS_INDICES  = "Efetuou Busca por Todos os indices com o seguinte par�metro: ";
	public static final String BUSCA_AVANCADA_SALVAR  		= "Busca Avan�ada inserida com os seguintes par�metros: ";
	public static final String BUSCA_AVANCADA_LISTA   		= "Lista Busca Avan�ada";
	public static final String BUSCA_AVANCADA_REMOVER_BUSCA = "Removeu Busca logicamente";
	public static final String BUSCA_AVANCADA_SELECIONADA 	= "Selionou a busca de iD :";
	
	public static final String RELATORIO_DINAMICO			= "Gerou Relat�rio Dinamico: ";	

	public static final String LOGO_CLIENTE 				= "Logo Cliente";

	public static final Object INICIA_EM 	= 0;
	public static final Object FINALIZA_EM  = 1;
	public static final Object CONTEM 		= 3;

	/**
	 * Parametro utilizado para a utilizacao ou nao da compactacao
	 */
	public static final String COMPACTAR_IMAGEM_VIEWER = "CompactarImagemViewer";
	public static final String TEM_QUERY_NATIVA = "QueryNativa";
	public static final String USA_INDEXER_LIGHT = "UsaIndexerLight";
	public static final String QUANTIDADE_DE_IMAGENS_PARA_PRE_LOADING = "QtdImagensPreloading";
	
	public static final Integer MAXIMO_LINHAS_MONITOR 			= 100;
	public static final String PARAMETRO_MAXIMO_LINHAS_MONITOR  = "MaximoLinhasMonitor";
	
	public static final Integer QUANTIDADE_MAXIMA_CARACTERES    = 255;

	public static final int LIMITE_TEXTO_LOG = 500;

	public static final String LOGIN_USUARIO_APLICACAO = "ADMIN";

	public static final String TRATAMENTO_IMAGEM_WEB_CROP = "CROP_IMAGEM";

	public static final String BOTAO_EXCLUIR_IMAGEM = "EXCLUIR_IMAGEM";

	public static final String PARAM_ATIVAR_ATALHO_TRATAMENTO_IMAGEM = "DesativaAtalhoComInputEmFoco";
	
	public static final String PARAM_CONFIG_IMAGEM_COLORIDA = "ImagemColorida";
	
	public static final String EXTENSAO_TIFF = "image/tiff";

	public static final String MSG_EXTENSAO_DIFERENTE_TIFF = "A imagem n�o � um arquivo do tipo tiff, seu tipo real �: ";

	public static final Object EXTENSAO_TIF = "tif";

	public static final String MODULO_TRATAR_VRS = "Tratar VRS";

	public static final String MODULO_OPERACINAL = "Operacional";

	public static final String BOTAO_EXCLUIR_CONFIG_DIGITALIZACAO = "Configura��o digitaliza��o exclu�da, nome config: ";
	
	public static final String TITLE_CODIGO_BARRA_PASTA = "Local definido para adicionar o c�digo de barras na imagem.";

	public static final String TITLE_PARAR_QUANTIDADE_PASTA_ATINGIDA = "Definir� a quantidade m�xima de pastas escaneadas. Ao atingir esta quantidade o escaneamento ser� interrompido. De acordo com o inserido na base, 0 � infinito";
	
	public static final String TITLE_TAMANHO_CODIGO_BARRAS_PASTA = "Configura�o tamanho m�ximo em pixels do c�digo de barras que ser� utilizado nas pastas.";

	public static final String TITLE_CODIGO_BARRA_DOCUMENTO = "Quatro inteiros separados por ponto e v�rgula. Ex.: 1;2;3;4";

	public static final String TITLE_EXCLUSAO_PAGINA_BRANCO_FRENTE = "Possui o valor em bites.";
	
	public static final String CONSULTAR_PASTAS_POR_PASTA_PAI_PERMISSAO = "SELECT" + 
			"         p.id_pasta," + 
			"         p.nome " + 
			"     FROM" + 
			"         pasta p " + 
			"" + 
			"     WHERE" + 
			"" + 
			"         p.id_pastapai=? " + 
			"         AND (" + 
			"             p.excluido=0 " + 
			"             OR p.excluido IS null" + 
			"         ) " + 
			"         AND (" + 
			"             p.id_funcionalidade IS null " + 
			"             OR p.id_funcionalidade IN (" + 
			"                 SELECT" + 
			"                     f.id_Funcionalidade " + 
			"                 FROM" + 
			"                     perfil_acesso_usuario pau " + 
			"                 INNER JOIN" + 
			"                     perfil_acesso pa " + 
			"                         on pau.id_perfil_acesso=pa.id_perfilacesso " + 
			"                 INNER JOIN" + 
			"                     perfil_acesso_funcionalidade paf " + 
			"                         ON pa.id_perfilacesso=paf.id_perfilacesso " + 
			"                 INNER JOIN" + 
			"                     funcionalidade f " + 
			"                         ON paf.id_funcionalidade=f.id_Funcionalidade " + 
			"                 WHERE" + 
			"                     pau.id_usuario=?" + 
			"             )" + 
			"         ) " + 
			"     ORDER BY" + 
			"         p.nome ASC ";
	
	public static final String QUANTIDADE_MAXIMA_DE_PASTAS= "SELECT "
			+ "valor "
			+ "FROM parametros_configuracao "
			+ "WHERE nome = 'QtdMaxPastas'";
	
	public static final int DEFAULT_MAX_PASTAS = 25;
	
	public static final int DEFAULT_MAX_DOCUMENTOS_PARA_DOWNLOAD = 50;
	
	public static final String QUANTIDADE_MAXIMA_DE_DOCUMENTOS_PARA_DOWNLOAD= "SELECT "
			+ "valor "
			+ "FROM parametros_configuracao "
			+ "WHERE nome = 'QtdMaxDocDownload'";
	
	public static final String BUSCA_PASTA_POR_NOME = "select p from Pasta p join fetch p.pasta where p.nome like :nomePasta and (p.excluido = 0 or p.excluido is null) "
			+ " and ((p.id_funcionalidade is null) or (p.id_funcionalidade in "
			+ " (select f.idFuncionalidade from PerfilAcessoUsuario pau join pau.perfilAcesso.funcionalidades f where pau.usuario.idUsuario =:idUsuario)) ) "
			+ " order by p.nome asc ";
	
	public static final String BUSCA_PASTA_POR_NOME_FILHOS = "select p from Pasta p where p.pasta.idPasta = :idPastaPai and (p.excluido = 0 or p.excluido is null) "
			+ " and ((p.id_funcionalidade is null) or (p.id_funcionalidade in "
			+ " (select f.idFuncionalidade from PerfilAcessoUsuario pau join pau.perfilAcesso.funcionalidades f where pau.usuario.idUsuario =:idUsuario)) ) "
			+ " order by p.nome asc ";
	
	public static final String BUSCAR_QUANTIDADE_IMAGENS_PARA_VIEWER_ONLY_PDF = "select count(*) from imagem img inner join repositorio_arquivos ra on img.id_repositorio=ra.id_repositorio where "
			+ "img.id_documento = :idDocumento and (img.excluida is null or img.excluida=0) and upper(img.arquivofinal) like '%.PDF' and (img.excluida is null or img.excluida = 0)";
	
	public static final String BUSCAR_QUANTIDADE_IMAGENS_PARA_VIEWER_ONLY_TIFF = "select count(*) from imagem img inner join repositorio_arquivos ra on img.id_repositorio=ra.id_repositorio where "
			+ "img.id_documento = :idDocumento and (img.excluida is null or img.excluida=0) and upper(img.arquivofinal) like '%.TIF' and (img.excluida is null or img.excluida = 0)";
	
	@SuppressWarnings("serial")
	public static final List<String> MODULOS = Collections.unmodifiableList(
		new ArrayList<String>() {{
			add("WebService");
			add("Operacional");
			add("Controle de Qualidade");
			add("OCR");
			add("Tratar VRS");
			add("Content");
			add("Indexa��o");
			add("Tratamento de Reprova��es");
			add("Redigitalizar");
			add("Redigitalizando");
		}}
	);
	
	public static final String PAGINA_BUSCA_RAPIDA = "buscaRapida";
	public static final String PAGINA_BUSCA_AVANCADA = "buscaAvancada";
	public static final String PAGINA_BUSCA_TEXTUAL = "buscaTextual";
	public static final String PAGINA_BUSCA_POR_TODOS_INDICES = "buscaPorTodosIndices";
	public static final String PAGINA_BUSCA_CAIXA = "buscaCaixa";
	public static final String PAGINA_ARVORE = "arvore";
	
	public static final int LIMIT_XLS = 65536;

	public static final float DEFAULT_DPI = 300.0f;
	public static final String BUSCA_DPI= "SELECT "
			+ "valor "
			+ "FROM parametros_configuracao "
			+ "WHERE nome = 'Dpi'";
	
	public static final double MM_PER_INCH = 25.4;
}
