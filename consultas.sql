SELECT 
    codigo, 
    titulo, 
    tipo, 
    disponivel 
FROM item;

SELECT 
    u.nome AS usuario, 
    i.titulo AS item, 
    e.data_retirada, 
    e.data_devolucao_prevista
FROM emprestimo e
JOIN usuario u ON e.usuario_id = u.id
JOIN item i ON e.item_id = i.id
WHERE e.data_devolucao IS NULL;

SELECT 
    u.nome AS usuario, 
    COALESCE(SUM(e.valor_multa), 0.00) AS total_multas
FROM usuario u
LEFT JOIN emprestimo e ON u.id = e.usuario_id
GROUP BY u.id, u.nome;

SELECT 
    i.codigo, 
    i.titulo, 
    i.tipo
FROM item i
LEFT JOIN emprestimo e ON i.id = e.item_id
WHERE e.id IS NULL; 