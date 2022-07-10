select
c.category_id,
parent_id,
key_name,
order_number,
is_available,
language_code,
header,
title,
text
from
cms_category c inner join cms_category_ml ml using (category_id)
