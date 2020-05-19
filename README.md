# TinyUrl
 generator of unique tiny values
 
          						   Under GPLv3 License

Do edit pom.properties file.

A sample unique thread-safe tiny url generator.

Every original URL must be unique.

Tech used is :: Spring boot, MongoDB, Thymeleaf.

MongoDb is preferred because of it's automatic 96 bits unique random generated STRING.

It is faster than mysql for non-relational data... as here only url generation is required irrespective of what enters into system.

Rest End Points are:: 

@RequestMapping(value="/generateUrl", method=RequestMethod.POST)
::Send your original URl and get back a set of 2 URLs.. 

	1st is Automatic generated url by mongodb database of 96 bits.
        2nd is a generated URL in sequential order of 7 characters, equivalent to 55,000,000,000,000 unique URLs.
	
For the time being, sequential generation is being done by keeping requests in synch while generating unique url.

@RequestMapping(value="/findByOriginalUrl", method=RequestMethod.POST)

Send your original URL and get back set of 2 URLs. 

@RequestMapping(value="/findBySeqUrl", method=RequestMethod.POST)

Send your Sequential Url and get back set of 2 urls.


@RequestMapping(value="/findByAutoUrl", method=RequestMethod.POST)

Send your automatic url and get back set of 2 urls.
