package manager;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.PrimeFaces;

import entity.Edu_escola;
import entity.Edu_escolas_modensino;
import entity.Edu_escolas_modensinoanos;
import entity.Edu_escolas_modensinovagas;
import entity.Edu_matr_candidato;
import entity.Edu_matr_candidatoReport;
import entity.Edu_matr_responsavel;
import entity.End_endereco;
import net.sf.jasperreports.engine.JasperRunManager;
import persistence.Edu_escolaDao;
import persistence.Edu_escolas_modensinoanosDao;
import persistence.Edu_escolas_modensinovagasDao;
import persistence.Edu_matr_candidatoDao;
import persistence.Edu_matr_candidatoReportDao;
import persistence.Edu_matr_responsavelDao;
import persistence.End_enderecoDao;
import report.DSReportCandidato;
import util.Biblioteca;
import util.SendMail;

@ManagedBean
@ViewScoped
public class Edu_matr_candidatoBean {
	
	public Edu_matr_candidato candidato;
	public Edu_matr_candidatoReport candidatoreport;
	public Edu_matr_responsavel responsavel;
	
	public End_endereco endereco;
	
	public Edu_escolas_modensino modensino;
	public Edu_escolas_modensinoanos modensinoanos;
	public Edu_escolas_modensinovagas modensinovagas;
	
	public List<Edu_matr_candidato> candidatolista;
	public List<Edu_escolas_modensino> modensinolista;
	public List<Edu_escolas_modensinoanos> modensinoanoslista;
	public List<Edu_escolas_modensinovagas> modensinovagaslista;
	public List<Edu_escola> escolalista;
	
	public List<String> modensinolistastr;       // lista filtrada de etapas 
	public List<String> modensinoanoslistastr;   // lista filtrada de anos
	public List<String> modensinovagaslistastr;  // lista filtrada de vagas
	
	public List<String> escolasorigem = new ArrayList<String>();
    public List<String> escolasselecionadas = new ArrayList<String>();
    
    public String idade;
    public Integer meses;
    public String etapaensino;
    public String etapaensinoanos;
    public Integer etapaensinoid;
    public String dadosemailhtml;
    
    public Boolean irmaonaescola;
    public Boolean necespeccandidato;

	public Edu_matr_candidatoBean() {
		
		limpaformulario();
	    
	    try {
	    	Edu_escolaDao ed = new Edu_escolaDao();
			
			escolalista = ed.listar();
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "")); // passa a mensagem
		}
	}

	public Boolean getNecespeccandidato() {
		return necespeccandidato;
	}

	public void setNecespeccandidato(Boolean necespeccandidato) {
		this.necespeccandidato = necespeccandidato;
	}

	public Integer getMeses() {
		return meses;
	}

	public void setMeses(Integer meses) {
		this.meses = meses;
	}

	public Edu_matr_candidatoReport getCandidatoreport() {
		return candidatoreport;
	}

	public void setCandidatoreport(Edu_matr_candidatoReport candidatoreport) {
		this.candidatoreport = candidatoreport;
	}

	public String getDadosemailhtml() {
		return dadosemailhtml;
	}

	public void setDadosemailhtml(String dadosemailhtml) {
		this.dadosemailhtml = dadosemailhtml;
	}

	public List<Edu_escola> getEscolalista() {
		return escolalista;
	}

	public void setEscolalista(List<Edu_escola> escolalista) {
		this.escolalista = escolalista;
	}

	public Boolean getIrmaonaescola() {
		return irmaonaescola;
	}

	public void setIrmaonaescola(Boolean irmaonaescola) {
		this.irmaonaescola = irmaonaescola;
	}

	public List<Edu_escolas_modensinovagas> getModensinovagaslista() {
		return modensinovagaslista;
	}

	public void setModensinovagaslista(List<Edu_escolas_modensinovagas> modensinovagaslista) {
		this.modensinovagaslista = modensinovagaslista;
	}

	public Edu_escolas_modensinovagas getModensinovagas() {
		return modensinovagas;
	}

	public void setModensinovagas(Edu_escolas_modensinovagas modensinovagas) {
		this.modensinovagas = modensinovagas;
	}

	public String getEtapaensinoanos() {
		return etapaensinoanos;
	}

	public void setEtapaensinoanos(String etapaensinoanos) {
		this.etapaensinoanos = etapaensinoanos;
	}

	public Integer getEtapaensinoid() {
		return etapaensinoid;
	}

	public void setEtapaensinoid(Integer etapaensinoid) {
		this.etapaensinoid = etapaensinoid;
	}

	public String getEtapaensino() {
		return etapaensino;
	}

	public void setEtapaensino(String etapaensino) {
		this.etapaensino = etapaensino;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public List<String> getEscolasorigem() {
		return escolasorigem;
	}

	public void setEscolasorigem(List<String> escolasorigem) {
		this.escolasorigem = escolasorigem;
	}

	public List<String> getEscolasselecionadas() {
		return escolasselecionadas;
	}

	public void setEscolasselecionadas(List<String> escolasselecionadas) {
		this.escolasselecionadas = escolasselecionadas;
	}

	public Edu_escolas_modensinoanos getModensinoanos() {
		return modensinoanos;
	}

	public void setModensinoanos(Edu_escolas_modensinoanos modensinoanos) {
		this.modensinoanos = modensinoanos;
	}

	public List<Edu_escolas_modensinoanos> getModensinoanoslista() {
		return modensinoanoslista;
	}

	public void setModensinoanoslista(List<Edu_escolas_modensinoanos> modensinoanoslista) {
		this.modensinoanoslista = modensinoanoslista;
	}

	public List<String> getModensinolistastr() {
		return modensinolistastr;
	}

	public void setModensinolistastr(List<String> modensinolistastr) {
		this.modensinolistastr = modensinolistastr;
	}

	public List<String> getModensinoanoslistastr() {
		return modensinoanoslistastr;
	}

	public void setModensinoanoslistastr(List<String> modensinoanoslistastr) {
		this.modensinoanoslistastr = modensinoanoslistastr;
	}

	public List<String> getModensinovagaslistastr() {
		return modensinovagaslistastr;
	}

	public void setModensinovagaslistastr(List<String> modensinovagaslistastr) {
		this.modensinovagaslistastr = modensinovagaslistastr;
	}

	public List<Edu_escolas_modensino> getModensinolista() {
		return modensinolista;
	}

	public void setModensinolista(List<Edu_escolas_modensino> modensinolista) {
		this.modensinolista = modensinolista;
	}

	public Edu_escolas_modensino getModensino() {
		return modensino;
	}

	public void setModensino(Edu_escolas_modensino modensino) {
		this.modensino = modensino;
	}

	public Edu_matr_responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Edu_matr_responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public End_endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(End_endereco endereco) {
		this.endereco = endereco;
	}

	public List<Edu_matr_candidato> getCandidatolista() {
		return candidatolista;
	}

	public void setCandidatolista(List<Edu_matr_candidato> candidatolista) {
		this.candidatolista = candidatolista;
	}

	public Edu_matr_candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Edu_matr_candidato candidato) {
		this.candidato = candidato;
	}
	
	public void ContinuarMatricula() {
		PrimeFaces.current().executeScript("PF('dialogoMatricula').show();");
	}
	
	public void ConcluirInscricao() {

		//System.out.println("Concluindo inscri��o");
		
		candidato.setAno_candidato(2022);
		candidato.setTipo_candidato("E");
		
		if (necespeccandidato) {
			candidato.setNecespec_candidato("S");
		} else {
			candidato.setNecespec_candidato("N");
		}
		
		System.out.println("Candidato: " + candidato);
		
		try {						
			
			Edu_matr_candidatoDao cd = new Edu_matr_candidatoDao();
			
			Boolean Candidatojaexiste = cd.testaCandidatoJaExiste(candidato);
			
			if (Candidatojaexiste) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este candidato j� possui inscri��o", "")); // passa a mensagem
			} else if (escolasselecionadas.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alguma op��o de escola deve ser escolhida", "")); // passa a mensagem
			} else if (escolasselecionadas.size()>3) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Por favor, selecione no m�ximo 3 (TR�S) op��es de escola", "")); // passa a mensagem
			} else {
				
				//System.out.println("Recuperando IDs das op��es");
				
				// Vou recuperar os Ids das escolhas do candidato
				
				for (int i = 0; i < escolasselecionadas.size(); i++) {
					
					for (int j = 0; j < modensinovagaslista.size(); j++) {
						if (escolasselecionadas.get(i)==modensinovagaslista.get(j).getNome_escola()) {
							if (i==0) {
								candidato.setId_modensinovagas1(modensinovagaslista.get(j).getId_modensinovagas());
							} else if (i==1) {
								candidato.setId_modensinovagas2(modensinovagaslista.get(j).getId_modensinovagas());
							} else {
								candidato.setId_modensinovagas3(modensinovagaslista.get(j).getId_modensinovagas());
							}
						}
					}									
				}
				
				//System.out.println("Gravando Respons�vel e recuperando ID");
				
				Edu_matr_responsavelDao rd = new Edu_matr_responsavelDao();
				
				//System.out.println("Responsavel: " + responsavel);
				
				Integer idresp = rd.gravar(responsavel);
				
				candidato.setId_responsavel(idresp);
				
				//System.out.println("Gravando candidato");				
				
				Integer idcandidato = cd.gravar(candidato);
				
				//System.out.println("Gravando endere�o");
				
				endereco.setIdentidade_endereco(idcandidato);
				endereco.setTipo_endereco("C");
				endereco.setUf_endereco("RJ");
				endereco.setCodigo_municipio("3303203");
				
				End_enderecoDao ed = new End_enderecoDao();
				
				ed.gravar(endereco);
				
				//System.out.println("Enviando email");
				
				enviaremailcandidato(idcandidato);
				
				//System.out.println("acabou");
				
				if (idcandidato == 0) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Houve um erro na grava��o do candidato", "")); // passa a mensagem
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Candidato gravado com sucesso", "")); // passa a mensagem
					
					FacesContext context = FacesContext.getCurrentInstance();
					
					String mensagesucesso = "";
					
					if (candidato.getNecespec_candidato().equalsIgnoreCase("S")) {
						mensagesucesso = "Sua pr� - matr�cula foi registrada.\n" +
										 "Em breve  faremos contato para agendar entrevista presencial.\n" +
										 "Solicitamos que nesse dia traga toda  documenta��o da crian�a, incluindo laudo e registro de acompanhamento m�dico.";
					} else if (etapaensino.equalsIgnoreCase("EJA")) {
						mensagesucesso = "Candidato a EJA deve ir diretamente na unidade escolhida para a " +
					                     "matr�cula sem necessidade de aguardar o resultado final " +
					                     "(Classifica��o)";
					} else {
						mensagesucesso = "Voc� realizou a pr�-matr�cula para concorrer a uma vaga escolar na " +
	 								"Rede Municipal de Nil�polis em 2022. O resultado final (Classifica��o) estar� " +
	 								"dispon�vel no dia 21/12/2021 no mesmo endere�o eletr�nico. " +
	 								"nilopolisdigital.com/matriculasonline";
					}	
					
					limpaformulario();					
			         
			        context.addMessage(null, new FacesMessage("Successful",  mensagesucesso) );
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "")); // passa a mensagem
			
			//System.out.println(e.getMessage());
		}
	}
	
	public void calculaidade() {
		if (!candidato.getNascimento_candidato().equalsIgnoreCase("")) {
			
			idade = Biblioteca.retornaIdadeEmUmaDataBase(candidato.getNascimento_candidato(), "31/03/2022").toString();
			
			candidato.setTipo_candidato("E"); // Setando tipo para candidato da educa��o
			
			preenchelistas();
			
//			System.out.println("Nascimento: " + candidato.getNascimento_candidato());
//			System.out.println("Idade: " + idade);
			
		}
	}
	
	private void preenchelistas() {
		Integer idadeInt = Integer.parseInt(idade);
		
		modensinolistastr = new ArrayList<String>();
		modensinoanoslistastr = new ArrayList<String>();
		
		meses = Math.abs((idadeInt * 12) - Biblioteca.retornaIdadeEmUmaDataBaseEmMeses(candidato.getNascimento_candidato(), "31/03/2022"));

		if (idadeInt == 0) {
			
			meses = Biblioteca.retornaIdadeEmUmaDataBaseEmMeses(candidato.getNascimento_candidato(), "31/03/2022");
			
			etapaensino = "EDUCA��O INFANTIL";
			etapaensinoid = 1;
			
			//System.out.println("Meses: " + meses);
			
			if (meses <=6){
				etapaensino = null;
				
				FacesContext context = FacesContext.getCurrentInstance();

				context.addMessage(null, new FacesMessage("Idade inv�lida!",  "O  candidato dever� ter 6 meses completos at� 31 03 2022") );				
				
			} else {
				modensinoanoslistastr.add("BER��RIO");
			}			
		} else if (idadeInt < 6) {
			etapaensino = "EDUCA��O INFANTIL";
			etapaensinoid = 1;
			
			modensinoanoslistastr.add("INFANTIL " + idadeInt);
		} else if (idadeInt == 6) {
			etapaensino = "ANOS INICIAIS";
			etapaensinoid = 2;
			
			modensinoanoslistastr.add("1� ANO");
			
		} else if (idadeInt < 11) {
			etapaensino = "ANOS INICIAIS";
			etapaensinoid = 2;
			
			modensinoanoslistastr.add("2� ANO");
			modensinoanoslistastr.add("3� ANO");
			modensinoanoslistastr.add("4� ANO");
			modensinoanoslistastr.add("5� ANO");
		} else if (idadeInt < 16) {
			etapaensino = "ANOS FINAIS";
			etapaensinoid = 3;
			
			modensinoanoslistastr.add("6� ANO");
			modensinoanoslistastr.add("7� ANO");
			modensinoanoslistastr.add("8� ANO");
			modensinoanoslistastr.add("9� ANO");
		} else {
			etapaensino = "EJA";
			etapaensinoid = 4;
			
			modensinoanoslistastr.add("I FASE");
			modensinoanoslistastr.add("II FASE");
			modensinoanoslistastr.add("III FASE");
			modensinoanoslistastr.add("IV FASE");
			modensinoanoslistastr.add("V FASE");
			modensinoanoslistastr.add("VI FASE");
			modensinoanoslistastr.add("VII FASE");
			modensinoanoslistastr.add("VIII FASE");
			modensinoanoslistastr.add("IX FASE");
		}
		
	}
	
	public void filtraescolas() {
		
		try {
			
//			System.out.println("Escolhendo escolas");
			
			Edu_escolas_modensinoanosDao ad = new Edu_escolas_modensinoanosDao();
			
			//System.out.println("etapaensinoanos: " + etapaensinoanos);
			
			modensinoanos = ad.findAno(etapaensinoanos);
			
			modensinovagas = new Edu_escolas_modensinovagas();
			
			modensinovagas.setId_modensino(etapaensinoid);
			modensinovagas.setId_modensinoanos(modensinoanos.getId_modensinoanos());
			
			Edu_escolas_modensinovagasDao ed = new Edu_escolas_modensinovagasDao();
			
			modensinovagaslista = ed.findAll(modensinovagas);
			
			escolasorigem = new ArrayList<String>();
			
			for (int i = 0; i < modensinovagaslista.size(); i++) {
				escolasorigem.add(modensinovagaslista.get(i).getNome_escola());
			}
			
		    escolasselecionadas = new ArrayList<String>();
		    
//		    System.out.println(escolasorigem);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
		
	}
	
	private void limpaformulario() {
		candidato = new Edu_matr_candidato();
		candidatoreport = new Edu_matr_candidatoReport();
		endereco = new End_endereco();
		responsavel = new Edu_matr_responsavel();
		modensino = new Edu_escolas_modensino();
		modensinoanos = new Edu_escolas_modensinoanos();
		modensinovagas = new Edu_escolas_modensinovagas();
		
		candidatolista = new ArrayList<Edu_matr_candidato>();
		modensinolista = new ArrayList<Edu_escolas_modensino>();
		modensinoanoslista = new ArrayList<Edu_escolas_modensinoanos>();
		modensinovagaslista = new ArrayList<Edu_escolas_modensinovagas>();
		
		modensinolistastr = new ArrayList<String>();
		modensinoanoslistastr = new ArrayList<String>();
		modensinovagaslistastr = new ArrayList<String>();
		escolasorigem = new ArrayList<String>();
	    escolasselecionadas = new ArrayList<String>();
	    
	    idade = "";
	    etapaensino = "";
	    etapaensinoanos = "";
	    etapaensinoid = 0;
	    
	    irmaonaescola = false;
	}
	
	public void enviaremailcandidato(Integer IdCandidato){
		
		if ((IdCandidato==null)||(IdCandidato==0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nenhum candidato encontrado para enviar email", "")); // passa a mensagem
		} else {
			FacesContext fc = FacesContext.getCurrentInstance();
			
			try{		
				
				List<Edu_matr_candidatoReport> lista = new Edu_matr_candidatoReportDao().findCandidato(IdCandidato);
				
				candidatoreport = lista.get(0);

				DSReportCandidato ds = new DSReportCandidato(lista);
				
				InputStream arquivo = FacesContext.getCurrentInstance()
					.getExternalContext().getResourceAsStream("/candidato.jasper");	

				byte[] pdf = JasperRunManager.runReportToPdf(arquivo, null, ds);
					
				String dest = candidatoreport.getEmail_candidato();
				
				SendMail sm = new SendMail();
				
				dadosemailhtml = "<br /> <strong>MATR�CULA NIL�POLIS 2022 - CANDIDATO <label>" +
		           		 "</label> </strong><br /> <br />" +
		           		 "<br /> Esta � uma confirma��o da sua CANDIDATURA � Matr�cula na rede de ensino do munic�pio de Nil�polis <br />" +
		           		 "<hr />" +
		           		 "<br /><br />Candidato         : " + candidatoreport.getNome_candidato() +
		           		 "<br /><br />Data de Nascimento: " + candidatoreport.getNascimento_candidato() +
		           		 "<br /><br />Bairro            : " + candidatoreport.getBairro_candidato() +
		           		 "<br /><br />" + 
		           		 "<br /><br />Respons�vel       : " + candidatoreport.getNome_responsavel() +
		           		 "<br /><br />" + 		           		 
		           		 "<br /><br />Op��es de Escola  : " + 
		           		 "<br /><br />" + 
		           		 "<br /><br />1� Op��o          : " + candidatoreport.getNome_escola1() +		           		 		           		
		           		 "<br /><br />2� Op��o          : " + candidatoreport.getNome_escola2() +
		           		 "<br /><br />3� Op��o          : " + candidatoreport.getNome_escola3() +
		           		 "<br /><br />" + 
		           		 "Voc� realizou a pr�-matr�cula para concorrer a uma vaga escolar na " +
		           		 "<br />" +
		           		 "Rede Municipal de Nil�polis em 2022. O resultado final  (Classifica��o) estar� " +
		           		 "<br />" +
		           		 "dispon�vel no dia 21/12/2021 no mesmo endere�o eletr�nico." +
		           		 "<br />" +
		           		 "(www.nilopolisdigital.com/matriculasonline)"+
		           		 "<div style='border:none;border-bottom:solid windowtext 1.0pt;padding:0cm 0cm 1.0pt 0cm'>" +
		           		 
		           		 "<table align='center'><tr>"+
		           		 "<td align='center'><img src='https://nilopolisdigital.com/imagens/logomatricula2022.jpg' alt='Matr�culas On Line 2022' /><br /><br />"+
		           		 "<strong>Sistema de Matr�culas On Line 2022 - Prefeitura Municipal de Nil�polis</strong>"+
		           		 "</td></tr></table>";
	
				String[] to = {dest, "itamar.gjr@gmail.com"}; 
				
				//System.out.println("para: " + to);
							
				sm.sendMailAttachment("inscricaoeducacaonilopolis@gmail.com", to, "Matr�cula Nil�polis 2022 - Candidato", dadosemailhtml, pdf);

				//fc.addMessage("enviaremailprepedidos", new FacesMessage("Email enviado com sucesso! "));	
				
			} catch (Exception e) {
				e.printStackTrace();
				
				fc.addMessage("enviaremailprepedidos", new FacesMessage("Erro ao enviar: " + e.getMessage()));	
			}
		}
	}
	
	public String imprimeCandidato(Integer IdCandidato){
		
		if ((IdCandidato==null)||(IdCandidato==0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nenhum candidato encontrado para enviar email", "")); // passa a mensagem
		} else {
			FacesContext fc = FacesContext.getCurrentInstance();
			
			try{		
				
				List<Edu_matr_candidatoReport> lista = new Edu_matr_candidatoReportDao().findCandidato(IdCandidato);
				
				candidatoreport = lista.get(0);

				DSReportCandidato ds = new DSReportCandidato(lista);
				
				InputStream arquivo = FacesContext.getCurrentInstance()
					.getExternalContext().getResourceAsStream("/candidato.jasper");	

				byte[] pdf = JasperRunManager.runReportToPdf(arquivo, null, ds);
					
				HttpServletResponse res = (HttpServletResponse) FacesContext
						.getCurrentInstance().getExternalContext().getResponse();
					
				res.setContentType("application/pdf");
				
				res.setContentLength(pdf.length);
					
				OutputStream out = res.getOutputStream();

				out.write(pdf, 0, pdf.length);

				out.flush();	
				
				out.close();
				
				FacesContext.getCurrentInstance().responseComplete();
				
				OutputStream fileout = new FileOutputStream("relatoriopreped.pdf");	
				
				fileout.write(pdf, 0, pdf.length);

				fileout.flush();	

				fileout.close();	
				
			} catch (Exception e) {
				e.printStackTrace();
				
				fc.addMessage("enviaremailprepedidos", new FacesMessage("Erro ao enviar: " + e.getMessage()));	
			}
		}
		
		return null;
	}
	
	public void buscarcandidato() {

		try {
			
			//System.out.println("Buscando candidato: " + candidatoreport);
			
			candidatoreport = new Edu_matr_candidatoReportDao().findCandidatoConsulta(candidatoreport);
			
			Edu_escolaDao ed = new Edu_escolaDao();
			
			if ((candidatoreport.getId_escola1()!=null)&&(candidatoreport.getId_escola1()!=0)) {
				candidatoreport.setNome_escola1(ed.retornaNome(candidatoreport.getId_escola1()));
			} 
			
			if ((candidatoreport.getId_escola2()!=null)&&(candidatoreport.getId_escola2()!=0)) {
				candidatoreport.setNome_escola2(ed.retornaNome(candidatoreport.getId_escola2()));
			}
			
			if ((candidatoreport.getId_escola3()!=null)&&(candidatoreport.getId_escola3()!=0)) {
				candidatoreport.setNome_escola3(ed.retornaNome(candidatoreport.getId_escola3()));
			}
			
			if (candidatoreport.getId_escola1()==null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Candidato n�o encontrado com os dados fornecidos", "")); // passa a mensagem
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "")); 	
		}	
	}
	
	public void imprimirInscricao() {
		imprimeCandidato(candidatoreport.getId_candidato());
	}
	
	public void reenviarInscricao() {
		
		try {
			enviaremailcandidato(candidatoreport.getId_candidato());
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Email enviado com sucesso", ""));
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}		
	}
	
	public void cancelarInscricao() {
		
		try {
			Edu_matr_candidatoReportDao cd = new Edu_matr_candidatoReportDao();
			
			cd.cancelaInscricao(candidatoreport);
			
			candidatoreport = new Edu_matr_candidatoReport();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Inscri��o cancelada!", "")); 
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "")); // passa a mensagem	
		}	
		
	}
}
