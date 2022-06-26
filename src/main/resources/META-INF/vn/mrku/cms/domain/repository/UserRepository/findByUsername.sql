select
    /*%expand*/*
from
    cms_user
where
    username = /* username */''
    and is_available