
-- Inserir automaticamente uma entrada na tabela produto_estoque com quantidade inicial zero sempre que um novo produto é adicionado à tabela produtos.


DELIMITER $

CREATE TRIGGER TRG_I_PRODUTOS AFTER INSERT
ON produtos 
FOR EACH ROW 
BEGIN 
	insert into produto_estoque (quantidade, produto_id) values (0, NEW.id);
END $

--Atualizar a quantidade de produtos no estoque após a inserção de novos itens em notas de entrada e saída.

DELIMITER $

CREATE TRIGGER TRG_I_NOTA_ENTRADA AFTER INSERT
ON NOTA_ENTRADA_ITEM
FOR EACH ROW 
BEGIN 
	UPDATE produto_estoque
    SET quantidade = quantidade + NEW.quantidade
    WHERE produto_id = NEW.produto_id;
END $

DELIMITER $

CREATE TRIGGER TRG_I_NOTA_SAIDA_ITEM AFTER INSERT
ON NOTA_SAIDA_ITEM
FOR EACH ROW 
BEGIN 
    UPDATE produto_estoque
    SET quantidade = quantidade - NEW.quantidade
    WHERE produto_id = NEW.produto_id;
END $


--Atualizar a quantidade de produtos no estoque quando itens são excluídos de notas de entrada ou saída.


DELIMITER $

CREATE TRIGGER TRG_D_NOTA_ENTRADA AFTER DELETE
ON NOTA_ENTRADA_ITEM
FOR EACH ROW 
BEGIN 
	UPDATE produto_estoque
    SET quantidade = quantidade - OLD.quantidade
    WHERE produto_id = OLD.produto_id;
END $

DELIMITER $
CREATE TRIGGER TRG_D_NOTA_SAIDA_ITEM AFTER DELETE
ON NOTA_SAIDA_ITEM
FOR EACH ROW 
BEGIN 
    UPDATE produto_estoque
    SET quantidade = quantidade + OLD.quantidade
    WHERE produto_id = OLD.produto_id;
END $


--Atualiza a quantidade de produtos no estoque quando ocorrem atualizações nas notas de entrada e saída. 

DELIMITER $

CREATE TRIGGER TRG_U_NOTA_ENTRADA AFTER UPDATE
ON NOTA_ENTRADA_ITEM
FOR EACH ROW 
BEGIN 
	UPDATE produto_estoque
    SET quantidade = quantidade - (OLD.quantidade - NEW.quantidade)
    WHERE produto_id = OLD.produto_id;
END $

DELIMITER $

CREATE TRIGGER TRG_U_NOTA_SAIDA_ITEM AFTER UPDATE
ON NOTA_SAIDA_ITEM
FOR EACH ROW 
BEGIN 
    UPDATE produto_estoque
    SET quantidade = quantidade + (OLD.quantidade - NEW.quantidade)
    WHERE produto_id = OLD.produto_id;
END $
