Create or replace view v_funcionario_depto
As
Select f.nome_funcionario,d.nome_departamento
From funcionario f inner join departamento d
On f.id_departamento=d.id_departamento;