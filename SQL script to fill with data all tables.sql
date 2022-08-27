USE hello_crm;

INSERT INTO sales_rep VALUES
                          ('1', 'Andrea'),
                          ('2', 'Bartolo'),
                          ('3', 'Clara');

INSERT INTO leads VALUES
                      ('1', 'Marogon', 'maragan@mail.com', 'Luis', '111222333', '1'),
                      ('2', 'Calabin', 'calabin@mail.com', 'Ana', '222333444', '1'),
                      ('3', 'Adene', 'adene@mail.com', 'Juan', '333444555', '1'),
                      ('4', 'Unicoy', 'unicoy@mail.com', 'Luisa', '444555666', '2'),
                      ('5', 'Teroni', 'teroni@mail.com', 'Carlos', '555666777', '2'),
                      ('6', 'Cadacene', 'cadacene@mail.com', 'Julia', '666777888', '2'),
                      ('7', 'Gamanama', 'gamanama@mail.com', 'Roberto', '777888999', '3'),
                      ('8', 'Tretre', 'tretre@mail.com', 'Anabel', '123147147', '3'),
                      ('9', 'Lobare', 'lobare@mail.com', 'Ignacio', '789369369', '3'),
                      ('10', 'Polonos', 'polonos@mail.com', 'Angel', '555444666', '1'),
                      ('11', 'Ulimet', 'ulimet@mail.com', 'Marta', '123456789', '1'),
                      ('12', 'Deneronico', 'deneronico@mail.com', 'Maria', '444999111', '2');

INSERT INTO accounts VALUES
                         ('6a864576-2594-11ed-861d-0242ac120002', 'London', 'UK', '1','1', 'Luis'),
                         ('6a864788-2594-11ed-861d-0242ac120002', 'Bristol', 'UK', '1','2', 'Ana'),
                         ('6a8648be-2594-11ed-861d-0242ac120002', 'Athens', 'Greece', '1','3', 'Paco'),
                         ('6a8649ea-2594-11ed-861d-0242ac120002', 'Corfu', 'Greece', '1','4', 'Carla'),
                         ('6a864b02-2594-11ed-861d-0242ac120002', 'Rome', 'Italy', '1','5', 'Gustavo'),
                         ('6a864c24-2594-11ed-861d-0242ac120002', 'Milan', 'Italy', '1','5', 'Smith');

INSERT INTO contacts VALUES
                         ('d087414e-2595-11ed-861d-0242ac120002', 'Antonio', '888777444', '6a864576-2594-11ed-861d-0242ac120002'),
                         ('d08743ec-2595-11ed-861d-0242ac120002', 'Pep', '689547412', '6a864788-2594-11ed-861d-0242ac120002'),
                         ('d08744dc-2595-11ed-861d-0242ac120002', 'Oriol', '587456985', '6a8648be-2594-11ed-861d-0242ac120002'),
                         ('d08745b8-2595-11ed-861d-0242ac120002', 'Joan', '214568985', '6a8649ea-2594-11ed-861d-0242ac120002'),
                         ('d0874694-2595-11ed-861d-0242ac120002', 'Carles', '325654785', '6a864b02-2594-11ed-861d-0242ac120002'),
                         ('d087477a-2595-11ed-861d-0242ac120002', 'Lluis', '454412236', '6a864c24-2594-11ed-861d-0242ac120002');

INSERT INTO opportunities VALUES
                      ('c3cde174-258b-11ed-861d-0242ac120002', 'HYBRID', '200', 'OPEN', 'd087414e-2595-11ed-861d-0242ac120002', '1'),
                      ('c3cde336-258b-11ed-861d-0242ac120002', 'FLATBED', '300', 'OPEN', 'd08743ec-2595-11ed-861d-0242ac120002', '1'),
                      ('c3cde656-258b-11ed-861d-0242ac120002', 'BOX', '400', 'OPEN', 'd08744dc-2595-11ed-861d-0242ac120002', '1'),
                      ('c3cde750-258b-11ed-861d-0242ac120002', 'HYBRID', '151', 'OPEN', 'd08745b8-2595-11ed-861d-0242ac120002', '2'),
                      ('c3cde82c-258b-11ed-861d-0242ac120002', 'FLATBED', '251', 'OPEN', 'd08745b8-2595-11ed-861d-0242ac120002', '2'),
                      ('c3cde91c-258b-11ed-861d-0242ac120002', 'BOX', '351', 'OPEN', 'd08745b8-2595-11ed-861d-0242ac120002', '2'),
                      ('c3cdea02-258b-11ed-861d-0242ac120002', 'HYBRID', '600', 'OPEN', 'd0874694-2595-11ed-861d-0242ac120002', '3'),
                      ('c3cdeaf2-258b-11ed-861d-0242ac120002', 'FLATBED', '700', 'OPEN', 'd0874694-2595-11ed-861d-0242ac120002', '3'),
                      ('c3cdebd8-258b-11ed-861d-0242ac120002', 'BOX', '800', 'OPEN', 'd0874694-2595-11ed-861d-0242ac120002', '3'),
                      ('c3cdecc8-258b-11ed-861d-0242ac120002', 'HYBRID', '444', 'OPEN', 'd087477a-2595-11ed-861d-0242ac120002', '1'),
                      ('c3cdef48-258b-11ed-861d-0242ac120002', 'FLATBED', '555', 'OPEN', 'd087477a-2595-11ed-861d-0242ac120002', '1'),
                      ('c3cdf038-258b-11ed-861d-0242ac120002', 'BOX', '666', 'OPEN', 'd087477a-2595-11ed-861d-0242ac120002', '2');