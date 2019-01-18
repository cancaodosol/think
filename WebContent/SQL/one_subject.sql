SELECT
	subjectid,
	title,
	linkurl,
	X.category1,
	TC1.name AS TC1,
	X.category2,
	TC2.name AS TC2,
	X.category3,
	TC3.name AS TC3,
	modified,
	content
FROM public.subjects AS X

LEFT JOIN t_category AS TC1 ON
X.category1 = TC1.category1 and TC1.category2 = 0 and TC1.category3 = 0

LEFT JOIN t_category AS TC2 ON
X.category1 = TC2.category1 and TC2.category2 = X.category2 and TC2.category3 = 0

LEFT JOIN t_category AS TC3 ON
X.category1 = TC3.category1 and TC3.category2 = X.category2 and TC3.category3 = X.category3


WHERE subjectid = ?;