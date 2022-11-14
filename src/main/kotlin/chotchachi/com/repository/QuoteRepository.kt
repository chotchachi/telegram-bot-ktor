package chotchachi.com.repository

class QuoteRepository {
    private val quotes = listOf(
        "Bạn gái muốn coi phim hoạt hình không những đồng ý mà còn cùng cô ấy đi xem.",
        "Lúc ăn cơm gắp đồ ăn cho bạn gái, có bao nhiêu món cô ấy thích đều bày ra hết trước mặt, miệng luôn nhắc nhở cô ấy ăn nhiều hơn.",
        "Khi bạn gái quan tâm, cố gắng dành thời gian cho cô ấy, dù rằng rất bận rộn vẫn cố gắng gọi cho cô ấy một cuộc.",
        "Cuộc đời quý giá nhất là lúc bên nhau, có lẽ lúc ấy ấm áp chỉ nhàn nhạt tựa như chén trà nóng trên bàn, nhưng khi mất đi, bỗng chốc thế giới lại hóa hoang vu, lạnh lẽo. Chỉ là chúng ta luôn chiến thắng không gian mà lại bất lực với thời gian.",
        "Cuộc đời vốn ngắn ngủi hơn chục năm, quan trọng là khiến bản thân vui vẻ chứ không phải làm vừa lòng người.",
        "Cô ấy xinh đẹp đến không chân thật. Cô ấy chân thật đến chẳng còn xinh đẹp.",
        "Tin tưởng với một người nặng sâu thế nào, không phải bạn có thể cùng hắn cười nhiều ra sao mà là bạn có bằng lòng khóc trước mặt hắn.",
        "Tôi sợ nhất không phải chứng kiến hai người yêu nhau rồi tổn thương nhau, mà là hai người yêu nhau đã lâu thật lâu lại đột ngột chia lìa, hóa thành hai người xa lạ. Tôi không chịu nổi quá trình tàn nhẫn ấy, tôi không hiểu tại sao lúc trước đã như máu thịt ăn sâu trong tim giờ lại biến thành sự lãng quên lạnh lùng, băng giá.",
        "Người đơn giản sống đời hạnh phúc rồi già đi. Giữ lấy trái tim tuổi trẻ, làm một người đơn giản, hưởng thụ ánh mặt trời ấm áp. Một đời như vậy là đủ.",
        "Bản thân hạnh phúc là được, chẳng cần phải luôn phơi bày cho người khác thấy. Phơi ra nhiều rồi có ngày sẽ bị phơi khô, cho nên cứ khiêm tốn là đủ.",
        "Làm một người đơn thuần, đi một đường hạnh phúc. Chúng ta thường thấy trái tim nặng nề là bởi đã suy nghĩ quá nhiều. Chúng ta luôn chê trách cuộc sống phiền phức lại không hiểu nổi phẩm vị của chính mình. Chúng ta vẫn luôn bận rộn với công việc lại không tìm thấy thứ mình thực sự ưa thích. Chúng ta luôn tranh cường hiếu thắng do lòng tham hư vinh quá lớn. Thực ra, cuộc sống vốn đơn giản lắm.",
        "Một người biết hướng mắt tới những vì sao sáng trên cao là người có hi vọng. Một người luôn cúi đầu nhìn những vật dưới chân là người không có tương lai.",
        "Cảm thấy khổ cực là do quá cưỡng cầu. Tình yêu thực sự sẽ cho bạn hạnh phúc, nếu chỉ có khổ đau thì nhất định sai rồi, không sao cả, kết thúc, làm lại.",
        "Nếu như em cứ vậy mà biến mất thì tôi sẽ dành nửa đời còn lại để tìm kiếm và chờ đợi em.",
        "Vòng quay ngựa gỗ là trò chơi xấu xa nhất trên đời, mãi đuổi theo nhau mà chẳng tài nào xóa bỏ khoảng cách.",
        "Nàng biết, hắn sẽ chẳng về nữa, dù cho nàng vẫn vậy nhu hòa như nước, vẫn vậy tươi cười tựa hoa, vẫn vậy mi mục như hoa, hắn biết rất rõ và nàng cũng biết. Nàng vốn chưa từng đổi thay, chỉ có hắn, và nàng hiểu.",
        "Cho dù việc ấy vô nghĩa đến nhường nào nhưng cứ kiên trì từng chút từng chút một thì hẳn vẫn khiến người phần nào để tâm.",
        "Trên đời này, đong sao nổi ái tình, từng chút từng chút góp nhặt ấy là cả đời.",
        "Ngoảnh mặt nhìn chuyện cũ thản nhiên nói không sao. Hướng đến tương lai kiên định tự nhủ phải nỗ lực hơn. Khi những nỗ lực hóa vô ích, ta mới chợt nhận ra bản thân thật sự nên để tâm đến điều gì.",
        "Có người đối tối với bạn là bởi bạn đã đối tốt với họ. Có người đối tốt với bạn là bởi họ hiểu bạn tốt đến mức nào.",
        "Xin lỗi vì tình yêu đôi ta cuối cùng cũng chịu thua thời gian và khoảng cách. Có lẽ thời gian hay khoảng cách cũng chỉ là một cái cớ, không còn yêu mới là lí do thật sự. Thật ra chỉ cần anh nói một lời, em sẽ buông tay, trả cho anh tự do, để anh đi tìm hạnh phúc đích thực của mình. Chỉ là, đừng dối gạt em, em không muốn anh phải làm ra vẻ như còn yêu em lắm.",
        "Gặp đúng người là cảm giác gì? Rất nhiều bạn nữ sau khi đã kết hôn tâm sự với tôi, cảm giác ấy có lẽ là người ấy chắc chắn sẽ không rời đi. Bạn không cần suy nghĩ, tìm cách, nghĩ ngợi làm sao để nắm giữ trái tim và dạ dày của anh ấy. Anh ấy thật sự sẽ không rời đi.",
        "Em không nhớ anh, chỉ là lúc thức giấc vẫn vội kiểm tra xem có tin nhắn hay điện thoại từ anh không. Em không nhớ anh, chỉ là cuộc điện thoại từ anh đã trở thành thanh âm quý giá nhất. Em không nhớ anh, chỉ là lúc nghe nhạc bắt gặp lời ca đồng điệu, trong đầu sẽ vô thức trống rỗng một mảng. Em không nhớ anh, chỉ là muốn nhìn thấy anh một lúc, muốn nghe giọng anh một chút. Em không nhớ anh, chỉ là mỗi lần tỉnh dậy em vẫn muốn nhìn thấy hình bóng anh.",
        "Bạn sẽ an bình vào ngày vượt qua quãng thời gian khó khăn của chính mình.",
        "Tôi tìm kiếm một tình yêu giảm bớt sự cô đơn, xoa dịu tâm hồn mình. Những lúc nhìn thế giới ngoài kia như hố sâu lạnh lẽo, thăm thẳm, tôi đột nhiên thấy mình sợ cô đơn biết bao. Tôi tìm kiếm một tình yêu, như sợi dây liên kết, họa nên trong tôi bức tranh về thiên đường mà các thánh giả và thi nhân từng nhắc tới."
    )

    fun getRandomQuote(): String {
        return quotes.random()
    }
}