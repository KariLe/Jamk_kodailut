<?php

use Illuminate\Database\Migrations\Migration;

class CreateShoppingTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('items', function($table) {
                $table->increments('id');
                $table->string('text');
                $table->boolean('bought');
                });
	}

	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('items');

	}

}