import com.example.random.service.RandomNumberGenerator;
import com.example.random.service.business.FastRandomNumberGenerator;
import com.example.random.service.business.SecureRandomNumberGenerator;

module com.example.random {
	exports com.example.random.service;
	provides RandomNumberGenerator 
	with FastRandomNumberGenerator,
	SecureRandomNumberGenerator;
}