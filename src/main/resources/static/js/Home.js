 $(document).ready(function() {
    $.ajax({
      url: '/articles',
      method: 'GET',
      dataType: 'html',
      success: function(data) {
        $('#articles-container').html(data);
      },
      error: function(err) {
        console.error('Error fetching articles:', err);
      }
    });
  });