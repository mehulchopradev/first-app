<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Create Book</title>
  </head>
  <body>
    <g:form name="bookForm" action="save">
      <g:textField name="title" placeholder="Enter title"/><br>
      <g:textField name="pages" placeholder="Enter Pages"/><br>
      <g:textField name="price" placeholder="Enter Price"/><br>
      <label for="category">
        Category
      </label>
      <g:select name="category.id" from="${categories}" optionKey="id" optionValue="description"/>
      <h2>Other Details</h2>
      <g:textField name="bookDetail.publication" placeholder="Enter publication"/><br>
      <g:textField name="bookDetail.isbn" placeholder="Enter isbn"/>
      <h2>Reviews</h2>
      <div>
        <g:textField name="reviews[0].description" placeholder="Review description"/>
        Ratings: <g:select name="reviews[0].rating" from="${[1,2,3,4,5]}" />
      </div>
      <div>
        <g:textField name="reviews[1].description" placeholder="Review description"/>
        Ratings: <g:select name="reviews[1].rating" from="${[1,2,3,4,5]}" />
      </div>
      <g:submitButton name="name" value="Save" />
    </g:form>
  </body>
</html>
