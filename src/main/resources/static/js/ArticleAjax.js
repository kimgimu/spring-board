$(function() {
   const articleId = $('#comment-article-id').val();
   showList();

    $('#delete-article-btn').click(function(){
        $.ajax({
            url : '/article/delete/'+articleId,
            method : 'POST'
        })
    })

    $('#comment-btn').click(function() {
        const comment = {
            nickname: $('#comment-nickname').val(),
            body: $('#comment-body').val(),
            articleId: $('#comment-article-id').val()
        };
        console.log(comment);

        $.ajax({
            url: '/comment/create',
            data: JSON.stringify(comment),
            type: 'POST',
            contentType: 'application/json',
            success: function(data) {
                if (data === 1) {
                    alert('댓글 작성 성공!');
                } else {
                    alert('댓글 작성 실패!');
                }
            },
            error: function(xhr, status, error) {
                alert('댓글 작성 실패!');
            }
        });
        showList();
    });

    function showList(){

        $.ajax({
           url : '/comment/show/'+articleId,
           method : 'GET',
           success : function(list){
            const commentList = $('#comment-list');
            list.forEach(function(comment){
            commentList.append('<p>'+comment.nickname+'<p>');
            commentList.append('<p>'+comment.body+'<p>');
           });
           },
              error: function(error) {
                       console.error("댓글 불러오기 에러:", error);
                   }
        });
    }



});


