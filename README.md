# SGS RPG — Sistema de Gerenciamento de Sessões de RPG

## Status do projeto
**Em desenvolvimento**

## Tecnologias utilizadas
- Java
- Java Swing para a interface gráfica desktop
- MySQL para armazenamento dos dados
- JDBC para conexão entre Java e MySQL
- NetBeans IDE para desenvolvimento
- Git e GitHub para versionamento do código-fonte

## Time de desenvolvedores
- **Desenvolvedor(a):** Niely Alberti

## Objetivo do software
O SGS RPG é um sistema desktop desenvolvido para auxiliar mestres de RPG de mesa no gerenciamento de sessões do universo de Ordem Paranormal. O sistema permite organizar agentes, equipes, missões, ameaças, itens e ocorrências, facilitando o acompanhamento das informações utilizadas durante as partidas.

## Funcionalidades do sistema
- **Gerenciamento de agentes:** cadastrar, consultar, alterar e excluir agentes, incluindo informações de classe, nível, vida, sanidade e status.
- **Gerenciamento de equipes:** cadastrar, consultar, alterar e excluir equipes.
- **Gerenciamento de missões:** registrar e administrar missões, com informações sobre equipe, local, grau de risco, datas e status.
- **Gerenciamento de ameaças:** cadastrar e administrar ameaças, seus tipos, elementos, níveis e status de aparição.
- **Gerenciamento de itens:** registrar e administrar itens, suas categorias, efeitos, níveis de perigo e status.
- **Gerenciamento de ocorrências:** registrar ocorrências relacionadas a missões e ameaças, incluindo impactos narrativos e na sanidade dos agentes.
- **Relatórios:** consultar missões por grau de risco, agentes com baixa sanidade e entidades mais recorrentes.
- **Persistência de dados:** armazenar e consultar informações em um banco de dados MySQL.

## Banco de dados
O sistema utiliza o banco de dados MySQL `SGS_rpg`. A conexão com o banco é realizada por JDBC.

## Observação
Este projeto faz parte de um Projeto Integrador do curso técnico em Análise de Sistemas e está sujeito a melhorias e atualizações durante o desenvolvimento.