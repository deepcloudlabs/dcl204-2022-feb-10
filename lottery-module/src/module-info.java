import com.example.random.service.RandomNumberGenerator;

module com.example.lottery {
	requires com.example.random;
	uses RandomNumberGenerator;
}