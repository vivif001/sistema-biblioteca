CREATE TABLE item (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor VARCHAR(100),
    edicao VARCHAR(20),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INT NOT NULL
);

CREATE TABLE emprestimo (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INT NOT NULL REFERENCES item(id),
    usuario_id INT NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10, 2) DEFAULT 0.00
);

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
('L001', 'Java: Como Programar', 'livro', 'Paul Deitel', '10a ed.', FALSE),
('L002', 'Clean Code', 'livro', 'Robert C. Martin', '1a ed.', TRUE),
('R001', 'Revista Java Magazine', 'revista', 'DevMedia', 'Ed. 120', TRUE),
('L003', 'Estruturas de Dados e Algoritmos', 'livro', 'Michael T. Goodrich', '6a ed.', TRUE);

INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Joao Silva', 'aluno', 3),
('Maria Oliveira', 'professor', 5);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
(2, 1, '2026-10-01', '2026-10-15', '2026-10-18', 1.50),
(1, 2, '2026-11-05', '2026-11-19', NULL, 0.00);