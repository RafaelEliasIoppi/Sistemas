
public enum DiasSemana {
	SEG("segunda-feira"), TER("terça-feira"), QUAR("quarta-feira"), QUI("quinta-feira"), SEX("sexta-feira"), SÁB("sábado"), DOM("domingo");

	private String descricao;


	private DiasSemana(String descricao) {
		this.descricao = descricao;
		}
	
	public String getDescricao() {
		return descricao;
	}
}