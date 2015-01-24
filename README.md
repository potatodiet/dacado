# dacado
Encodes data into image files, also decodes those images.

# Library Usage
```java
final TextEncoder textEncoder = new TextEncoder("Just a test.");

try {
    ImageIO.write(textEncoder.getEncodedImage(), "PNG", new File("text.png"));
} catch (IOException e) {
    e.printStackTrace();
}

final Decoder decoder = new Decoder("text.png");
System.out.println(decoder.getText());
```
