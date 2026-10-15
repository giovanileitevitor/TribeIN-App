package br.tribein.ui.theme

object AppStrings {
    const val APP_NAME = "TRIBE IN"
    const val APP_VERSION = "1.0.0"
    const val APP_NAME_DESCRIPTION = "O mundo é feito de conexões... "
    const val SPLASH_LOADING = "INICIALIZANDO APP.."
    const val SPLASH_MERCHAN = "Sua jornada de controle de Dividendos"
    const val SPLASH_COPYRIGHT = "© Copyright reserved to TribeIN."
    const val LOADING_TEXT_DEFAULT = "Atualizando..."
    const val LoadingTextLogin = "Verificando..."
    const val TotalDividendsLabel = "TOTAL DE DIVIDENDOS RECEBIDOS ATÉ O MOMENTO: "
    const val AverageDividends = "Média de Dividendos"
    const val TotalAssets = "Ativos Totais"
    const val MonthlyPerformance = "Desempenho por Mês"
    const val RecentDividends = "Dividendos Recentes"
    const val SEE_ALL = "Ver tudo"
    const val SEE_DETAILS = "Ver detalhes"
    const val ACCUMULATED_TITLE = "TOP 10 Empresas Pagadoras"
    const val NoDividends = "Nenhum dividendo registrado."
    const val DeleteDividendTitle = "Excluir Dividendo"
    const val DeleteDividendConfirm = "Deseja realmente excluir o dividendo de "

    const val DeleteAction = "Excluir"
    const val CancelAction = "Cancelar"
    const val RECEIVED_AT = "Recebido em: "
    const val Shares = " ações"
    const val EmptyValue = "R$ 0,00"
    const val CurrencyPrefix = "R$ "
    const val AddDescription = "Add"
    const val NotificationsDescription = "Notifications"
    const val REFRESH_BUTTON = "Refresh"

    //AddDividendScreen
    const val ADD_DIVIDEND_INFO = "Registre seus proventos recebidos para manter seu portfólio atualizado."
    const val ADD_DIVIDEND_TITLE = "Adicionar Novo Dividendo"
    const val LOADING_ADD_DIVIDEND = "Adicionando dividendo..."
    const val TickerName = "Ticker da Ação / FII"
    const val DefaultTickerName = "EX: PETR4 ou XPML11"
    const val ValueName = "Valor Recebido"
    const val EmptyValueName = "R$ 0,00"
    const val DataName = "Data do Recebimento"
    const val DefaultDataName = "dd/mm/yyyy"
    const val QtdName = "Quantidade de ações"
    const val DefaultQtdName = "0"
    const val TickerType = "Tipo de Ativo: AÇÃO ou FII"
    const val DEFAULT_EXPENSE_IMG_NAME = "Img_xpto.jpg"
    const val DefaultTickerType = "AÇÃO ou FII"
    const val BtnSaveDividend = "Salvar Dividendo"

    // Accumulated Screen Strings
    const val AccumulatedValue = "TOTAL RECEBIDO:"
    const val ActionText = "AÇÃO"

    // View Dividends Screen Strings
    const val VIEW_DIVIDENDS_TITLE_SCREEN = "Todos os Dividendos"
    const val ExportLabel = "Exportar"
    const val SearchLabel = "Procurar"
    const val BackDescription = "Voltar"

    // Login Screen Strings
    const val LoginSubtitle = "STOCK IN"
    const val TXT_LOGIN_DESCRIPTION = "Seu app de controle financeiro \n(Gastos e Proventos)"
    const val EmailLabel = "Informe seu EMAIL"
    const val EmailPlaceholder = "seu@email.com"
    const val PasswordLabel = "Informe sua SENHA"
    const val PasswordPlaceholder = "••••••••"
    const val ForgotPassword = "Esqueci minha senha?"
    const val RecordPassword = "Salvar Login"
    const val LoginButton = "Entrar"
    const val NoAccount = "Ainda não tem uma conta?"
    const val CreateAccount = "Criar nova conta"
    const val PASSWORD_VISIBLE = "Mostrar senha"
    const val PASSWORD_HIDDEN = "Ocultar senha"

    // Wallet Screen Strings
    const val MY_WALLETS = "Meus Ativos"
    const val CURRENT_WALLET = "CARTEIRA ATUAL"
    const val NEW_ASSET = "NOVO ATIVO"
    const val AVERAGE_LABEL = "Médio: "
    const val ACTIONS = "ações"
    const val ADD_ITEM_WALLET = "Adicionar Novo Ativo"

    // Add Item Screen Strings
    const val ADD_ITEM_TITLE = "Adicionar Novo Ativo"
    const val ITEM_AVERAGE_VALUE = "Valor médio do Ativo"
    const val LOADING_ADD_STOCK = "Adicionando ativo ..."
    const val DELETE_ITEM_WALLET_TITLE = "Excluir Ativo"
    const val DELETE_ITEM_MESSAGE = "Deseja realmente excluir o ativo de "
    const val BTN_ADD_ITEM = "Adicionar Novo Ativo"

    // Stock Details Screen Strings
    const val MAIN_INDICATORS = "Principais Indicadores: "
    const val PL_INDICATOR = "P/L (Preço / Lucro)"
    const val PVPA_INDICATOR = "P/VPA (Preço / Pat )"

    // NewAccount Screen Strings
    const val CREATE_ACCOUNT_TITLE = "Criar nova conta na Stock IN"
    const val NEW_ACCOUNT_SUBTITLE = "Tenha total controle dos seus dividendos."
    const val FULL_NAME_LABEL = "NOME COMPLETO"
    const val FULL_NAME_PLACEHOLDER = "Ex: João Silva"
    const val EMAIL_LABEL_NEW = "EMAIL"
    const val EMAIL_PLACEHOLDER_NEW = "nome@email.com"
    const val PASSWORD_LABEL_NEW = "SENHA"
    const val PASSWORD_PLACEHOLDER_NEW = "••••••••"
    const val PROFESSION_LABEL = "PROFISSÃO"
    const val PROFESSION_PLACEHOLDER = "Selecione sua ocupação"
    const val ACCEPT_TERMS_TEXT = "Li e concordo com os termos do contrato de criação de conta na StockIN e demais termos relacionados."
    const val CREATE_ACCOUNT_BUTTON = "Criar conta"
    const val ALREADY_HAVE_ACCOUNT = "Já tem uma conta? "
    const val LOGIN_TEXT = "Login"

    // Forgot Password Screen Strings
    const val FORGOT_PASSWORD_TITLE = "Esqueci minha senha"
    const val EMAIL_LABEL_RESET = "Informe o email cadastrado"
    const val RESET_ACCOUNT_BUTTON = "Recuperar senha →"
    const val LOADING_TXT_RESET = "Verificando email..."

    // About Screen Strings
    const val ABOUT_TITLE = "Configurações"
    const val ABOUT_APP_SECTION = "SOBRE O APP"
    const val ABOUT_APP_DESCRIPTION = "O StockIN é seu parceiro ideal para gestão de dividendos e acompanhamento de ativos em tempo real. Nossa missão é simplificar sua jornada como investidor, trazendo clareza e eficiência para sua carteira."
    const val REGISTRATION_DATA_SECTION = "DADOS CADASTRAIS"
    const val GPS_COORDINATES_LABEL = "ÚLTIMA LOCALIZAÇÃO (LAT / LONG)"
    const val SIGNATURE_LABEL = "TIPO DE ASSINATURA (GRATUITO / PAGO)"
    const val LOAD_GPS_COORDINATES_BUTTON = "OBTER COORDENADAS"
    const val GPS_PERMISSION_HELP_TEXT = "Permissão de localização negada. Para habilitar, vá em Configurações > Permissões do app e permita acesso à localização."
    const val OPEN_APP_SETTINGS_BUTTON = "ABRIR CONFIGURAÇÕES DO APP"
    const val EXIT_BUTTON = "SAIR"
    const val DELETE_ACCOUNT_BUTTON = "DELETAR CONTA"
    const val VERSION_INFO = "Made for Investors"

    // Expenses Screen Strings
    const val EXPENSES_TITLE = "Controle de Gastos"
    const val NO_EXPENSES = "Nenhuma despesa registrada."
    const val TOTAL_EXPENSES_ACC = "Gasto Total Acumulado no Ano: "
    const val DELETE_PAYMENT_TITLE = "Excluir Gasto"
    const val DELETE_PAYMENT_CONFIRM = "Deseja realmente excluir o gasto de "
    const val RECENT_EXPENSES = "Gastos Recentes"
    const val SEE_ALL_EXPENSES = "Ver tudo"

    // Add Expense Screen Strings
    const val ADD_EXPENSE_TITLE = "Adicionar novo gasto"
    const val LOADING_ADD_EXPENSE = "Aguarde..."
    const val ADD_EXPENSE_INFO = "Registre seus gastos diários para manter seu controle financeiro."
    const val EXPENSE_DESCRIPTION = "Descrição do gasto"
    const val DEFAULT_EXPENSE_DESCRIPTION = "EX: Aluguel, Internet, etc."
    const val EXPENSE_VALUE = "Valor Gasto"
    const val EXPENSE_DATE = "Data do Gasto"
    const val EXPENSE_IMAGE = "Foto do Gasto"
    const val BTN_SAVE_EXPENSE = "Registrar Gasto"
    const val EXPENSE_TYPE = "Tipo de Gasto"
    const val EXPENSE_TYPE_PLACEHOLDER = "Selecione o tipo de gasto"

    // View Expenses Screen Strings
    const val VIEW_EXPENSES_TITLE_SCREEN = "Todos os Gastos"
    const val NO_EXPENSES_REGISTERED = "Nenhum gasto registrado."
}
