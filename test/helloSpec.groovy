import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification

public class helloSpec extends JenkinsPipelineSpecification {

	def Jenkinsfile = null

	public static class DummyException extends RuntimeException {
		public DummyException(String _message) { super( _message ); }
	}

	def setup() {
		Jenkinsfile = loadPipelineScriptForTest("/vars/hello.groovy")
		//Jenkinsfile.getBinding().setVariable( "scm", null )
		explicitlyMockPipelineVariable("hello")
		getPipelineMock("load")("hello.groovy") >> {
			getPipelineMock("hello")
		}
	}
