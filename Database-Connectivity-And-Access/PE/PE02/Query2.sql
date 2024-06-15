SELECT DISTINCT R.name 
FROM recipes.recipe R
WHERE R.RecipeId NOT IN (
  SELECT DISTINCT r.RecipeId
  FROM recipes.recipe r
  JOIN recipes.ingredientlist il USING(RecipeId)
  JOIN recipes.ingredients i USING(IngredientId)
  WHERE i.type IN ('beef', 'pork', 'chicken', 'lamb'));
