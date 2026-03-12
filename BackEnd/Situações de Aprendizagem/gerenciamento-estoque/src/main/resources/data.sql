-- 1. USUÁRIOS (Necessário para login e ações)
INSERT INTO funcionarios_autenticados (nome, nif, ativo) VALUES ('Admin SENAI', '123456', true);

INSERT INTO funcionarios (nome, nif, senha, ativo) VALUES ('Admin SENAI', '123456', '1234', true);

-- 2. CATEGORIAS

INSERT INTO categorias (nome, descricao) VALUES ('Eletrônica', 'Componentes eletrônicos, placas e microcontroladores');
INSERT INTO categorias (nome, descricao) VALUES ('Informática', 'Computadores, periféricos e cabos de rede');
INSERT INTO categorias (nome, descricao) VALUES ('Manufatura Maker', 'Insumos para impressão 3D e corte a laser');
INSERT INTO categorias (nome, descricao) VALUES ('Ferramentas', 'Ferramentas manuais, elétricas e de bancada');


-- 3. MATERIAIS DE CONSUMO (Estoque)

-- Material 1: Com estoque folgado
INSERT INTO materiais (nome, descricao, unidade_medida, quantidade_atual, quantidade_minima, categoria_id)
VALUES ('Resistor 1k Ohm', 'Resistor de filme de carbono 1/4W', 'UN', 500, 100, 1);

-- Material 2: COM ESTOQUE BAIXO (Para testar o alerta em vermelho na tela!)
INSERT INTO materiais (nome, descricao, unidade_medida, quantidade_atual, quantidade_minima, categoria_id)
VALUES ('Cabo de Rede Cat6', 'Cabo UTP Azul', 'METRO', 20, 50, 2); 

-- Material 3: Estoque no limite
INSERT INTO materiais (nome, descricao, unidade_medida, quantidade_atual, quantidade_minima, categoria_id)
VALUES ('Resina Wash & Cure', 'Resina lavável em água para impressora SLA', 'LITRO', 3, 2, 3);

-- 4. ATIVOS PATRIMONIAIS (Bens Duráveis)

INSERT INTO ativos_patrimoniais (numero_tombamento, nome, numero_serie, estado_conservacao, localizacao, data_aquisicao, categoria_id)
VALUES ('SENAI-1001', 'Osciloscópio Digital 2 Canais', 'TK987654', 'BOM', 'Laboratório de Eletrônica 01', '2023-05-10', 1);

INSERT INTO ativos_patrimoniais (numero_tombamento, nome, numero_serie, estado_conservacao, localizacao, data_aquisicao, categoria_id)
VALUES ('SENAI-1002', 'Impressora 3D Creality Ender 3 V2', 'CR321654', 'NOVO', 'Espaço Maker', '2024-01-20', 3);

INSERT INTO ativos_patrimoniais (numero_tombamento, nome, numero_serie, estado_conservacao, localizacao, data_aquisicao, categoria_id)
VALUES ('SENAI-1003', 'Torno Mecânico de Bancada', 'TM554433', 'EM MANUTENÇÃO', 'Oficina Mecânica', '2022-11-15', 4);

-- 5. MOVIMENTAÇÕES (Histórico Inicial)
INSERT INTO movimentacoes (tipo, quantidade, data_hora, observacao, material_id, funcionario_id)
VALUES ('ENTRADA', 500, CURRENT_TIMESTAMP, 'Compra de lote inicial para o semestre', 1, 1);

INSERT INTO movimentacoes (tipo, quantidade, data_hora, observacao, material_id, funcionario_id)
VALUES ('ENTRADA', 20, CURRENT_TIMESTAMP, 'Resto de rolo do semestre passado', 2, 1);

INSERT INTO movimentacoes (tipo, quantidade, data_hora, observacao, material_id, funcionario_id)
VALUES ('ENTRADA', 3, CURRENT_TIMESTAMP, 'Doação de empresa parceira', 3, 1);