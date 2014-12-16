load("js/uglify/lib/utils.js");
load("js/uglify/lib/ast.js");
load("js/uglify/lib/parse.js");
load("js/uglify/lib/transform.js");
load("js/uglify/lib/scope.js");
load("js/uglify/lib/output.js");
load("js/uglify/lib/compress.js");

var default_options = {};
function uglify(code, options) {
	// Create copies of the options
	var parse_options = defaults({}, options.parse);
	var compress_options = defaults({}, options.compress);
	var output_options = defaults({}, options.output);

	parse_options = defaults(parse_options, default_options.parse, true);
	compress_options = defaults(compress_options, default_options.compress, true);
	output_options = defaults(output_options, default_options.output, true);

	var tab = "        ";
	print(tab+"Parsing...");

	// 1. Parse
	var toplevel_ast = parse(code, parse_options);
	toplevel_ast.figure_out_scope();

	print(tab+"DONE.\n");
	print(tab+"Compressing...");

	// 2. Compress
	var compressor = new Compressor(compress_options);
	var compressed_ast = toplevel_ast.transform(compressor);

	print(tab+"DONE.\n");
	print(tab+"Mangling...");

	// 3. Mangle
	compressed_ast.figure_out_scope();
	compressed_ast.compute_char_frequency();
	compressed_ast.mangle_names();

	print(tab+"DONE.\n");
	print(tab+"Generating output...");

	// 4. Generate output
	code = compressed_ast.print_to_string(output_options);
	print(tab+"DONE.\n");

	return code;
}