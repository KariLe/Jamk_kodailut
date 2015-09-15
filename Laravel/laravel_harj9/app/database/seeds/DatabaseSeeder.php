<?php

class DatabaseSeeder extends Seeder {

	/**
	 * Run the database seeds.
	 *
	 * @return void
	 */
	public function run()
	{
		Eloquent::unguard();
                //joku seeder juttu joka ajetaan
		$this->call('UserTableSeeder');
	}

}